package per.wph.info.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import per.wph.info.model.UserInfo;

import java.util.List;

public interface UserService extends BaseService{
    //根据用户ID获取用户
    UserInfo getUserInfoById(Long id);

    //根据用户名查找
    UserInfo getUserInfoByUsername(String username);

    //获取所有用户
    List<UserInfo> getAll();

    //保存用户
    boolean saveUserInfo(UserInfo userInfo);
}
