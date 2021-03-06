package per.wph.info.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import per.wph.info.model.UserInfo;

import java.util.List;
import java.util.Set;

@Mapper
@Repository
public interface UserInfoMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long uid);

    UserInfo selectByUsername(String username);

    Set<Long> selectRoleIdsByUsername(String username);

    List<UserInfo> selectAll();

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}