package per.wph.info.service.impl;

import org.springframework.stereotype.Service;
import per.wph.info.model.SysRole;
import per.wph.info.service.SysRoleService;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl implements SysRoleService{
    @Override
    public Set<SysRole> getSysRolesByUsername(String username) {
        Set<Long> ids = userInfoMapper.selectRoleIdsByUsername(username);
        Set<SysRole> roles = sysRoleMapper.selectByPrimaryKeys(ids);
        return roles;
    }

    @Override
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
