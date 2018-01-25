package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.info.mapper.SysRoleMapper;
import per.wph.info.model.SysRole;
import per.wph.info.service.RoleService;

import java.util.LinkedHashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SysRoleTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Test
    public void SysRoleMapperTest1(){
        SysRole sysRole = new SysRole();
        sysRole.setRole("管理员");
        sysRoleMapper.insert(sysRole);
    }

    @Test
    public void SysRoleMapperTest2(){
        Set<Long> ids = new LinkedHashSet<>();
        ids.add(Long.valueOf(1));
        ids.add(Long.valueOf(2));
        sysRoleMapper.selectByPrimaryKeys(ids);
    }

    @Autowired
    private RoleService roleService;

    @Test
    public void SysRoleServiceTest1(){
        Set<SysRole> sysRoles = roleService.getSysRolesByUsername("1122");
        System.out.println(sysRoles);
    }

    @Test
    public void SysRoleServiceTest2(){
        Set<String> roleNames = roleService.getSysRoleNamesByUsername("1122");
        System.out.println(roleNames.toArray()[0]);
    }
}
