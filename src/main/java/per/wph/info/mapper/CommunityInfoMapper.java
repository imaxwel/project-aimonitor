package per.wph.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import per.wph.info.model.CommunityInfo;

@Mapper
@Repository
public interface CommunityInfoMapper {
    int deleteByPrimaryKey(Long cid);

    int insert(CommunityInfo record);

    CommunityInfo selectByPrimaryKey(Long cid);

    List<CommunityInfo> selectAll();

    List<CommunityInfo> selectAllUnDetail();

    int updateByPrimaryKey(CommunityInfo record);
}