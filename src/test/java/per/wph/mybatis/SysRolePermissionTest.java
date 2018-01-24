package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.info.mapper.SysRolePermissionMapper;
import per.wph.info.model.SysRolePermission;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class SysRolePermissionTest {

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Test
    public void Test1(){
        SysRolePermission sysRolePermission = new SysRolePermission();
        sysRolePermission.setPermissionId(Long.valueOf(1));
        sysRolePermission.setRoleId(Long.valueOf(1));
        sysRolePermissionMapper.insert(sysRolePermission);
    }
}
