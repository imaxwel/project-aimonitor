package per.wph.engine.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.engine.model.FaceFeature;
@Mapper
@Repository
public interface FaceFeatureMapper {
    int deleteByPrimaryKey(Long fid);

    int insert(FaceFeature record);


    List<FaceFeature> selectAll();

    int updateByPrimaryKey(FaceFeature record);
}