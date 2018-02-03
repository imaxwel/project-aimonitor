package per.wph.info.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import per.wph.common.service.BaseServiceImpl;
import per.wph.info.model.SysRole;
import per.wph.info.service.RoleService;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
@CacheConfig(cacheNames = "role")
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {
    @Override
    public Set<SysRole> getSysRolesByUsername(String username) {
        Set<Long> ids = userInfoMapper.selectRoleIdsByUsername(username);
        Set<SysRole> roles = sysRoleMapper.selectByPrimaryKeys(ids);
        return roles;
    }

    @Override
    @Cacheable(key="'getSysRoleNamesByUsername_' + #p0")
    public Set<String> getSysRoleNamesByUsername(String username) {
        Set<Long> ids = userInfoMapper.selectRoleIdsByUsername(username);
        Set<SysRole> roles = sysRoleMapper.selectByPrimaryKeys(ids);
        Set<String> roleNames = new LinkedHashSet<>();
        Iterator<SysRole> iterator = roles.iterator();
        while(iterator.hasNext()){
            roleNames.add(iterator.next().getRole());
        }
        return roleNames;
    }
}
