package per.wph.info.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import per.wph.info.mybatis.model.UserInfo;

@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long uid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}