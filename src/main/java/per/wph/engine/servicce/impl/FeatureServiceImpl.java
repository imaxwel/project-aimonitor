package per.wph.engine.servicce.impl;

import org.apache.tomcat.util.modeler.FeatureInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.wph.common.exception.DllUnavailableException;
import per.wph.common.exception.ZeroFaceException;
import per.wph.common.service.BaseServiceImpl;
import per.wph.engine.clib.EngineDll;
import per.wph.engine.clib.EngineDllManager;
import per.wph.engine.clib.FaceModel;
import per.wph.engine.mapper.FaceFeatureMapper;
import per.wph.engine.model.FaceFeature;
import per.wph.engine.model.view.BaseFeatureView;
import per.wph.engine.model.view.OwnerFaceFeatureView;
import per.wph.engine.model.view.StrangerFaceFeatureView;
import per.wph.engine.model.view.VisitorFaceFeatureView;
import per.wph.engine.servicce.FeatureService;
import per.wph.info.model.*;

import java.io.*;
import java.util.*;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-30 16:43
 * =============================================
 */
@Service
public class FeatureServiceImpl extends BaseServiceImpl implements FeatureService {
    @Override
    @Transactional
    public Long saveFeatureInfo(FaceFeature faceFeature) {
        faceFeatureMapper.insert(faceFeature);
        return faceFeature.getFid();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long saveFeatureInfoByImage(String filePath) throws DllUnavailableException, IOException, ZeroFaceException {
        FaceModel faceModel = EngineDllManager.getFeatureByImage(filePath);
        byte[] bytes = new byte[faceModel.lFeatureSize];
        faceModel.pbFeature.read(0,bytes,0,bytes.length);
        FaceFeature faceFeature = new FaceFeature();
        File file = new File(filePath);
        if(file.exists()){
            StringBuilder image = new StringBuilder();
            byte[] buff = new byte[5000];
            FileInputStream fis = new FileInputStream(file);
            while (fis.read(buff)!=-1){
                image.append(buff);
            };
            faceFeature.setImage(image.toString().getBytes());
        }
        faceFeature.setCreateTime(new Date());
        faceFeature.setFeature(bytes);
        faceFeatureMapper.insert(faceFeature);
        return faceFeature.getFid();
    }

    @Override
    public List<FaceFeature> getOwnerAndVsisotrFeatureIdListByOid(Long oid) {
        return faceFeatureMapper.selectOwnerAndVsisotrFeatureIdListByOid(oid);
    }

    @Override
    public FaceFeature getFaceFeatureByFid(Long fid) {
        return faceFeatureMapper.selectByFid(fid);
    }

    @Override
    public int deleteImageByFid(Long fid) {
        return faceFeatureMapper.deleteByPrimaryKey(fid);
    }


    @Override
    public boolean isAccess(byte[] feature, Long cid, Long bid) throws DllUnavailableException {
        //判断是否是业主
        if(!isOwner(feature,cid,bid,true,new ArrayList<OwnerFaceFeatureView>())){
            //判断是否是访客
            if(!isVisitor(feature,cid,bid,true,new ArrayList<VisitorFaceFeatureView>())){
                //判断是否是陌生人
                if(isStranger(feature,cid,bid,true)){
                    return false;
                }
            }
        };
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean isOwner(byte[] feature, Long cid, Long bid, Boolean recordOrNot,List<OwnerFaceFeatureView> ffvl) throws DllUnavailableException {
        ffvl = faceFeatureMapper.selectOwnerFaceFeatureView(cid, bid);
        EngineDllManager.getConforming(ffvl,feature,0.6f);
        //日志记录
        if(recordOrNot && ffvl.size()>0){
            RecordOwnerVisit recordOwnerVisit = new RecordOwnerVisit();
            OwnerFaceFeatureView offv = findMatchesAmongList(ffvl);
            recordOwnerVisit.setOid(offv.getOid());
            recordOwnerVisit.setBid(bid);
            recordOwnerVisit.setCid(cid);
            recordOwnerVisit.setStatus(RecordOwnerVisit.RecordStatus.ACCESS.status());
            recordOwnerVisit.setTime(new Date());
            recordOwnerVisitMapper.insert(recordOwnerVisit);
        }
        return ffvl.size()>0;
    }

    @Override
    public boolean isStranger(byte[] feature, Long cid, Long bid, Boolean recordOrNot) {
        if(recordOrNot){
            RecordStrangerVisit recordStrangerVisit = new RecordStrangerVisit();
            recordStrangerVisit.setBid(bid);
            recordStrangerVisit.setCid(cid);
            recordStrangerVisit.setStatus(RecordStrangerVisit.RecordStatus.UNACCESS.status());
            recordStrangerVisit.setTime(new Date());
            recordStrangerVisitMapper.insert(recordStrangerVisit);
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean isVisitor(byte[] feature, Long cid, Long bid, Boolean recordOrNot,List<VisitorFaceFeatureView> ffvl) throws DllUnavailableException {
        ffvl = faceFeatureMapper.selectVisitorFaceFeatureView(cid, bid);
        EngineDllManager.getConforming(ffvl,feature,0.6f);
        if(recordOrNot && ffvl.size()>0){
            RecordVisitorVisit recordVisitorVisit = new RecordVisitorVisit();
            VisitorFaceFeatureView visitorFaceFeatureView = findMatchesAmongList(ffvl);
            recordVisitorVisit.setBid(bid);
            recordVisitorVisit.setCid(cid);
            recordVisitorVisit.setStatus(RecordVisitorVisit.RecordStatus.ACCESS.status());
            recordVisitorVisit.setTime(new Date());
            recordVisitorVisitMapper.insert(recordVisitorVisit);
        }
        return ffvl.size()>0;
    }


    /**
     * 寻找最匹配的业主
     * @param ffvl
     * @return
     */
    private<T extends BaseFeatureView> T findMatchesAmongList(List<T> ffvl){
        T offv = ffvl.stream().max(((o1, o2) -> {return (int)(o1.getDegree()-o2.getDegree());})).get();
        return offv;
    }


}
