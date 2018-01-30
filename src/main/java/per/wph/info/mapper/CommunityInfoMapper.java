package per.wph.info.mapper;

import java.util.List;
import per.wph.info.model.CommunityInfo;

public interface CommunityInfoMapper {
    int deleteByPrimaryKey(Long cid);

    int insert(CommunityInfo record);

    CommunityInfo selectByPrimaryKey(Long cid);

    List<CommunityInfo> selectAll();

    int updateByPrimaryKey(CommunityInfo record);
}