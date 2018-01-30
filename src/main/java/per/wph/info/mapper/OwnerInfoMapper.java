package per.wph.info.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.OwnerInfo;

@Mapper
@Repository
public interface OwnerInfoMapper {
    int insert(OwnerInfo record);

    int insertSelective(OwnerInfo record);
}