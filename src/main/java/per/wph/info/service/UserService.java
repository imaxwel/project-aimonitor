package per.wph.info.service;

import org.apache.catalina.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import per.wph.info.model.UserInfo;

import java.util.List;

public interface UserService extends BaseService{
    //默认用户注册身份为游客
    final static Long DEFAULT_ROLE = 0L;

    //根据用户ID获取用户
    UserInfo getUserInfoById(Long id);

    //根据用户名查找
    UserInfo getUserInfoByUsername(String username);

    //获取所有用户
    List<UserInfo> getAll();

//    //保存用户
//    int saveUserInfo(UserInfo userInfo);

    //更新用户
    int updateUserInfo(UserInfo userInfo);

    //用户注册
    int userRegist(UserInfo userInfo);


}
