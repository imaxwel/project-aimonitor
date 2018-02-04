package per.wph.info.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.wph.common.service.BaseServiceImpl;
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

//    @Override
//    @Transactional
//    public int saveUserInfo(UserInfo userInfo) {
//        return userInfoMapper.insert(userInfo);
//    }

    @Override
    @Transactional
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public int userRegist(UserInfo userInfo) {
        passwordUtil.encryptPassword(userInfo);
        userInfoMapper.insert(userInfo);
        sysRoleMapper.insertUserRole(userInfo.getUid(),DEFAULT_ROLE);
        return 1;
    }

}
