package per.wph.mybatis;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class PasswordTest {

    @Test
    public void defaultPasswordServiceTest(){
        DefaultPasswordService defaultPasswordService = new DefaultPasswordService();
        String pass = defaultPasswordService.encryptPassword(new String("3344"));
        Boolean result = defaultPasswordService.passwordsMatch("3344",pass);
        System.out.println(pass);
        System.out.println(result);
    }

    @Test
    public void MD5HashTest(){

        Md5Hash md5 = new Md5Hash("1122","3344",2);
        System.out.println(md5.toHex());
        Md5Hash md52 = new Md5Hash("1122","3344",2);
        System.out.println(md52.toHex());
    }
}
