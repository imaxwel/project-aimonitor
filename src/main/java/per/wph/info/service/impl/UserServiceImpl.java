package per.wph.info.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import per.wph.info.model.UserInfo;
import per.wph.info.service.UserService;

import java.util.List;

@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Override
    public UserInfo getUserInfoById(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserInfo getUserInfoByUsername(String username) {
        return userInfoMapper.selectByUsername(username);
    }

    @Override
    public List<UserInfo> getAll(){
        return userInfoMapper.selectAll();
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

}
