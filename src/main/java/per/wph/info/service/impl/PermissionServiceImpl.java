package per.wph.info.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import per.wph.info.mapper.SysRoleMapper;
import per.wph.info.model.SysPermission;
import per.wph.info.model.SysRole;
import per.wph.info.service.PermissionService;

import java.util.*;

@Service("permissionService")
@CacheConfig(cacheNames = "perm")
public class PermissionServiceImpl extends BaseServiceImpl implements PermissionService {
    @Override
    public Set<SysPermission> getSysPermissionsByUsername(String username) {
        Set<Long> ids = userInfoMapper.selectRoleIdsByUsername(username);
        Set<SysRole> roles = sysRoleMapper.selectByPrimaryKeys(ids);
        Iterator<SysRole> iterator = roles.iterator();
        Set<Long> roleIds = new LinkedHashSet<>();
        while(iterator.hasNext()){
            roleIds.add(iterator.next().getId());
        }
        Set<SysPermission> permissions = sysPermissionMapper.selectByRoleIds(roleIds);
        return permissions;
    }

    @Override
    public Set<String> getSysPermissionNamesByUsername(String username) {
        Set<Long> ids = userInfoMapper.selectRoleIdsByUsername(username);
        Set<SysRole> roles = sysRoleMapper.selectByPrimaryKeys(ids);
        Iterator<SysRole> iterator = roles.iterator();
        Set<Long> roleIds = new LinkedHashSet<>();
        while(iterator.hasNext()){
            roleIds.add(iterator.next().getId());
        }
        Set<SysPermission> permissionNames = sysPermissionMapper.selectByRoleIds(roleIds);
        Iterator<SysPermission> iterator1 = permissionNames.iterator();
        Set<String> names = new LinkedHashSet<>();
        while(iterator1.hasNext()){
            names.add(iterator1.next().getName());
        }
        return names;
    }

    @Override
    @Cacheable(key="'getPermissionUrlsByUsername_' + #p0")
    public List<String> getPermissionUrlsByUsername(String username) {
        Set<Long> roleIds = userInfoMapper.selectRoleIdsByUsername(username);
        Set<SysPermission> permissions = sysPermissionMapper.selectByRoleIds(roleIds);
        Iterator<SysPermission> iterator = permissions.iterator();
        List<String> urls = new ArrayList<>();
        while(iterator.hasNext()){
            urls.add(iterator.next().getUrl());
        }
        return urls;
    }

}
