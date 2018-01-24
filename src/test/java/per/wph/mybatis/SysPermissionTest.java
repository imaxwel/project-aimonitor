package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.info.mapper.SysPermissionMapper;
import per.wph.info.model.SysPermission;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class SysPermissionTest {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Test
    public void SysPermissionMapperTest1(){
        SysPermission sysPermission = new SysPermission();
        sysPermission.setName("修改权限");
        sysPermissionMapper.insert(sysPermission);
    }
}
