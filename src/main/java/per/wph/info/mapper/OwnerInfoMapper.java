package per.wph.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.OwnerInfo;
import per.wph.info.model.view.OwnerInfoView;
import per.wph.info.model.view.OwnerRegistView;

@Mapper
@Repository
public interface OwnerInfoMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(OwnerInfo record);

    OwnerInfo selectByPrimaryKey(Long oid);

    OwnerInfoView selectByUsername(String username);

    List<OwnerInfo> selectAll();

    int updateByPrimaryKey(OwnerInfo record);

    List<OwnerInfoView> selectOwnerAndBuildingInfoByAdminUsername(String username);

    OwnerRegistView getOwnerRegistViewByPrimaryKey(Long oid);
}