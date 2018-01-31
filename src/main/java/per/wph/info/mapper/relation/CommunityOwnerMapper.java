package per.wph.info.mapper.relation;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.relation.CommunityOwner;
import org.apache.ibatis.annotations.Param;

@Repository
@Mapper
public interface CommunityOwnerMapper {
    int deleteByPrimaryKey(@Param("cid") Long cid, @Param("oid") Long oid);

    int insert(CommunityOwner record);

    List<CommunityOwner> selectAll();
}