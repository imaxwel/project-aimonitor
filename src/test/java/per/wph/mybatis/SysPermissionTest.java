package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.info.mapper.SysPermissionMapper;
import per.wph.info.mapper.UserInfoMapper;
import per.wph.info.model.SysPermission;
import per.wph.info.service.PermissionService;

import javax.annotation.Resource;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class SysPermissionTest {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private PermissionService permissionService;
    @Test
    public void SysPermissionMapperTest1(){
        SysPermission sysPermission = new SysPermission();
        sysPermission.setName("修改权限");
        sysPermissionMapper.insert(sysPermission);
    }

    @Test
    public void SysPermissionMapperTest2(){
        Set<Long> ids = new LinkedHashSet<>();
        ids.add(Long.valueOf(1));
        Set<SysPermission> sysPermissions = sysPermissionMapper.selectByRoleIds(ids);
    }

    @Test
    public void SysPermissionMapperTest3(){
        Set<String> names = permissionService.getSysPermissionNamesByUsername("1122");
    }

    @Test
    public void SysPermissionMapperTest4(){
        List<String> urls = permissionService.getPermissionUrlsByUsername("1122");
    }

    @Test
    public void SysPermissionMapperTest5(){
        Set<Long> roleIds = userInfoMapper.selectRoleIdsByUsername("3344");
        Set<SysPermission> permissions = sysPermissionMapper.selectByRoleIds(roleIds);
        System.out.println();
    }

    @Test
    public void SysPermissionServiceTest6(){
        List<String> names = permissionService.getPermissionUrlsByUsername("491739727");
        System.out.println(names);
    }

}
