package per.wph.info.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import per.wph.info.model.UserInfo;

import java.util.List;

public interface UserInfoService extends BaseService{
    //根据用户ID获取用户
    UserInfo getById(Long id);

    //根据用户名查找
    UserInfo getByUsername(String username);

    //获取所有用户
    List<UserInfo> getAll();
}
