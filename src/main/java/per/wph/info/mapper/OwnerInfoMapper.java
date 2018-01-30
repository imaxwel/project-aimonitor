package per.wph.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.OwnerInfo;

@Mapper
@Repository
public interface OwnerInfoMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(OwnerInfo record);

    OwnerInfo selectByPrimaryKey(Long uid);

    List<OwnerInfo> selectAll();

    int updateByPrimaryKey(OwnerInfo record);
}