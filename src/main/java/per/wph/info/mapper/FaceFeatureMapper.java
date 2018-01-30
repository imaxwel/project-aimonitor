package per.wph.info.mapper;

import java.util.List;
import per.wph.info.model.FaceFeature;

public interface FaceFeatureMapper {
    int deleteByPrimaryKey(Long fid);

    int insert(FaceFeature record);

    FaceFeature selectByPrimaryKey(Long fid);

    List<FaceFeature> selectAll();

    int updateByPrimaryKey(FaceFeature record);
}