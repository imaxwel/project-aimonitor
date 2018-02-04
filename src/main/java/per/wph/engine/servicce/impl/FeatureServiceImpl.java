package per.wph.engine.servicce.impl;

import org.apache.tomcat.util.modeler.FeatureInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.wph.common.exception.DllUnavailableException;
import per.wph.common.exception.ZeroFaceException;
import per.wph.engine.clib.EngineDll;
import per.wph.engine.clib.EngineDllManager;
import per.wph.engine.clib.FaceModel;
import per.wph.engine.mapper.FaceFeatureMapper;
import per.wph.engine.model.FaceFeature;
import per.wph.engine.model.view.BaseFeatureView;
import per.wph.engine.model.view.OwnerFaceFeatureView;
import per.wph.engine.model.view.VisitorFaceFeatureView;
import per.wph.engine.servicce.FeatureService;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-30 16:43
 * =============================================
 */
@Service
public class FeatureServiceImpl implements FeatureService {
    private static final int MAX_IMAGE_SIZE = 5000;
    @Autowired
    private FaceFeatureMapper faceFeatureMapper;

    @Override
    @Transactional
    public Long saveFeatureInfo(FaceFeature faceFeature) {
        faceFeatureMapper.insert(faceFeature);
        return faceFeature.getFid();
    }

    @Override
    @Transactional
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
    public boolean isAccess(byte[] feature, Long cid, Long bid) {
        return false;
    }

    @Override
    public boolean isOwner(byte[] feature, Long cid, Long bid, Boolean recordOrNot,List<OwnerFaceFeatureView> ffvl) throws DllUnavailableException {
        ffvl = faceFeatureMapper.selectOwnerFaceFeatureView(cid, bid);
        EngineDllManager.getConforming(ffvl,feature,0.6f);
        if(recordOrNot && ffvl.size()>0){
            
        }
        return ffvl.size()>0;
    }

    @Override
    public boolean isStranger(byte[] feature, Long cid, Long bid, Boolean recordOrNot) {
        return false;
    }

    @Override
    public boolean isVisitor(byte[] feature, Long cid, Long bid, Boolean recordOrNot,List<VisitorFaceFeatureView> ffvl) throws DllUnavailableException {
        ffvl = faceFeatureMapper.selectVisitorFaceFeatureView(cid, bid);
        EngineDllManager.getConforming(ffvl,feature,0.6f);
        return ffvl.size()>0;
    }




}
