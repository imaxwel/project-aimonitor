package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.common.util.SpringContentUtil;
import per.wph.info.service.PermissionService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SptingContentUtilTest {


    @Test
    public void test1(){
        PermissionService permissionService = SpringContentUtil.getApplicationContext().getBean(PermissionService.class);
        permissionService.getPermissionUrlsByUsername("1122");
    }
}
