package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.common.MsgTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class EnumTest {

    @Test
    public void EnumTest1(){
        System.out.println(MsgTemplate.tag.DEFAULT.message());
        System.out.println(MsgTemplate.tag.DEFAULT.status());
    }
}
