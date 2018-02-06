package per.wph.info.mapper.relation;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.relation.OwnerFeature;

@Repository
@Mapper
public interface OwnerFeatureMapper {
    int insert(OwnerFeature record);

    List<OwnerFeature> selectAll();

    int deleteByOid(Long oid);

    OwnerFeature selectByPrimaryKey(Long fid);
}