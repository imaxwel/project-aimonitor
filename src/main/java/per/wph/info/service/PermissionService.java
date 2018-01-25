package per.wph.info.service;

import per.wph.info.model.SysPermission;

import java.util.List;
import java.util.Set;

public interface PermissionService extends BaseService{

    //根据用户名获得用户所有权限
    Set<SysPermission> getSysPermissionsByUsername(String username);

    //根据用户名获得用户所拥有的权限的名字
    Set<String> getSysPermissionNamesByUsername(String username);

    //获得所有权限名字
    List<String> getPermissionUrlsByUsername(String username);
}
