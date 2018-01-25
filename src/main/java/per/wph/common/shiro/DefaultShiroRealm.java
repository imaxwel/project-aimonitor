package per.wph.common.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import per.wph.info.model.SysRole;
import per.wph.info.model.UserInfo;
import per.wph.info.service.BaseService;
import per.wph.info.service.SysPermissionService;
import per.wph.info.service.SysRoleService;
import per.wph.info.service.UserInfoService;

import java.util.List;
import java.util.Set;

public class DefaultShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 权限配置
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        String u = (String) principal.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> sysRoles = sysRoleService.getSysRoleNamesByUsername(u);
        Set<String> sysPermissions = sysPermissionService.getSysPermissionNamesByUsername(u);
        info.setRoles(sysRoles);
        info.setStringPermissions(sysPermissions);
        return info;
    }

    /**
     * 用户认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        UserInfo userInfo = userInfoService.getUserInfoByUsername(username);
        if(userInfo==null){
            throw new AccountException("帐号或密码不正确！");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo.getUsername(), //用户名
                userInfo.getPassword(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
