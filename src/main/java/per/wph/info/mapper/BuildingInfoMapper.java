package per.wph.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.BuildingInfo;

@Mapper
@Repository
public interface BuildingInfoMapper {
    int deleteByPrimaryKey(Long bid);

    int insert(BuildingInfo record);

    BuildingInfo selectByPrimaryKey(Long bid);

    List<BuildingInfo> selectAll();

    int updateByPrimaryKey(BuildingInfo record);
}