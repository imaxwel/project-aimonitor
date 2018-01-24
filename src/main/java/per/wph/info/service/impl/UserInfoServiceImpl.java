package per.wph.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import per.wph.info.mapper.UserInfoMapper;
import per.wph.info.model.UserInfo;
import per.wph.info.service.UserInfoService;

import javax.annotation.Resource;
import java.util.List;

@Service
@CacheConfig(cacheNames = "user")
public class UserInfoServiceImpl extends BaseServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    @Cacheable(key = "'userinfo_id' + #p0")
    public UserInfo getById(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserInfo> getAll(){
        return userInfoMapper.selectAll();
    }

}
