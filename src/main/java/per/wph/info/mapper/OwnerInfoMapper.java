package per.wph.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.OwnerInfo;
import per.wph.info.model.view.OwnerInfoView;

@Mapper
@Repository
public interface OwnerInfoMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(OwnerInfo record);

    OwnerInfo selectByPrimaryKey(Long oid);

    List<OwnerInfo> selectAll();

    int updateByPrimaryKey(OwnerInfo record);

    List<OwnerInfoView> selectOwnerAndBuildingInfoByAdminUsername(String username);
}