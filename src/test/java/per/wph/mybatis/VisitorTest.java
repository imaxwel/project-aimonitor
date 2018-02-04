package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.info.mapper.VisitorInfoMapper;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-04 14:16
 * =============================================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class VisitorTest {

    @Autowired
    VisitorInfoMapper visitorInfoMapper;

    @Test
    public void test1(){
        visitorInfoMapper.selectAll();
    }
}
