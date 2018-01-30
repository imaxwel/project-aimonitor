package per.wph.info.mapper;

import java.util.List;
import per.wph.info.model.EquipmentInfo;

public interface EquipmentInfoMapper {
    int deleteByPrimaryKey(Integer eid);

    int insert(EquipmentInfo record);

    EquipmentInfo selectByPrimaryKey(Integer eid);

    List<EquipmentInfo> selectAll();

    int updateByPrimaryKey(EquipmentInfo record);
}