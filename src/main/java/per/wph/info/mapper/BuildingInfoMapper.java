package per.wph.info.mapper;

import java.util.List;
import per.wph.info.model.BuildingInfo;

public interface BuildingInfoMapper {
    int deleteByPrimaryKey(Long bid);

    int insert(BuildingInfo record);

    BuildingInfo selectByPrimaryKey(Long bid);

    List<BuildingInfo> selectAll();

    int updateByPrimaryKey(BuildingInfo record);
}