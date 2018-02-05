package per.wph.engine.servicce;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import per.wph.common.exception.DllUnavailableException;
import per.wph.common.exception.ZeroFaceException;
import per.wph.engine.model.FaceFeature;
import per.wph.engine.model.view.OwnerFaceFeatureView;
import per.wph.engine.model.view.VisitorFaceFeatureView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FeatureService {

    Long saveFeatureInfo(FaceFeature faceFeature);

    Long saveFeatureInfoByImage(String filePath) throws DllUnavailableException, IOException, ZeroFaceException;

    List<FaceFeature> getOwnerAndVsisotrFeatureIdListByOid(Long oid);

    FaceFeature getFaceFeatureByFid(Long fid);

    //删除照片
    int deleteImageByFid(Long fid);

    /**
     * 判断是否通过
     * @param feature 特征值
     * @param cid 小区id
     * @param bid 楼栋id
     * @return 返回识别结果
     * @throws DllUnavailableException dll不可用异常
     */
    boolean isAccess(byte[] feature,Long cid,Long bid) throws DllUnavailableException;

    /**
     * 判断是否是业主
     * @param feature 特征值
     * @param cid 小区id
     * @param bid 楼栋id
     * @param recordOrNot 是否记录结果
     * @param ffvl 需要返回的结果集
     * @return 返回识别结果
     * @throws DllUnavailableException dll不可用异常
     */
    boolean isOwner(byte[] feature, Long cid, Long bid, Boolean recordOrNot,List<OwnerFaceFeatureView> ffvl) throws DllUnavailableException;

    /**
     * 判断是否是陌生人
     * @param feature 特征值
     * @param cid 小区id
     * @param bid 楼栋id
     * @param recordOrNot 是否记录结果
     * @return 返回true
     */
    boolean isStranger(byte[] feature, Long cid, Long bid,Boolean recordOrNot);

    /**
     * 判断是否是访客
     * @param feature 特征值
     * @param cid 小区id
     * @param bid 楼栋id
     * @param recordOrNot 是否记录结果
     * @param ffvl 需要返回的结果集
     * @return 返回识别结果
     * @throws DllUnavailableException dll不可用异常
     */
    boolean isVisitor(byte[] feature,Long cid,Long bid,Boolean recordOrNot,List<VisitorFaceFeatureView> ffvl) throws DllUnavailableException;
}
