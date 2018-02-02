package per.wph.info.mapper.relation;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import per.wph.info.model.relation.CommunityBuilding;
import org.apache.ibatis.annotations.Param;

@Mapper
@Repository
public interface CommunityBuildingMapper {
    int deleteByPrimaryKey(@Param("cid") Long cid, @Param("bid") Long bid);

    int insert(CommunityBuilding record);

    List<CommunityBuilding> selectAll();

    List<CommunityBuilding> selectByCid(Long cid);
}