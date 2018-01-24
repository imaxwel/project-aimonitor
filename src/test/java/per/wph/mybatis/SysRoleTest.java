package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.info.mapper.SysRoleMapper;
import per.wph.info.model.SysRole;

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
}
