package per.wph.engine.mapper;

import java.util.List;

import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import per.wph.engine.model.FaceFeature;
import per.wph.engine.model.view.BaseFeatureView;
import per.wph.engine.model.view.OwnerFaceFeatureView;
import per.wph.engine.model.view.VisitorFaceFeatureView;

@Mapper
@Repository
public interface FaceFeatureMapper {
    int deleteByPrimaryKey(Long fid);

    int insert(FaceFeature record);

    List<FaceFeature> selectAll();

    int updateByPrimaryKey(FaceFeature record);

    /**
     * 获取业主所有可用的特征View,包括未通过认证的
     * @param cid
     * @param bid
     * @return
     */
    List<OwnerFaceFeatureView> selectOwnerFaceFeatureView(@Param("cid") Long cid, @Param("bid") Long bid);

    /**
     * 获取所有业主可用的特征View,不包括未认证的
     * @param cid
     * @param bid
     * @return
     */
    List<OwnerFaceFeatureView> selectAvailableOwnerFaceFeatureView(@Param("cid") Long cid, @Param("bid") Long bid,@Param("stauts")Integer stauts);

    List<VisitorFaceFeatureView> selectVisitorFaceFeatureView(@Param("cid") Long cid, @Param("bid") Long bid);

    List<FaceFeature> selectOwnerAndVsisotrFeatureIdListByOid(Long oid);

    FaceFeature selectByFid(Long fid);
}