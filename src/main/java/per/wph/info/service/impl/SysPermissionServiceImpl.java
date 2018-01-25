package per.wph.info.service.impl;

import org.springframework.stereotype.Service;
import per.wph.info.model.SysPermission;
import per.wph.info.model.SysRole;
import per.wph.info.service.SysPermissionService;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class SysPermissionServiceImpl extends BaseServiceImpl implements SysPermissionService{
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
}
