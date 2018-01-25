package per.wph.info.service;

import per.wph.info.model.SysRole;

import java.util.List;
import java.util.Set;

public interface RoleService extends BaseService {

    //根据用户名获得用户所拥有的角色
    Set<SysRole> getSysRolesByUsername(String username);

    //根据用户名获得用户所拥有的角色的名字
    Set<String> getSysRoleNamesByUsername(String username);
}
