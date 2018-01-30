package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.info.mapper.OwnerInfoMapper;
import per.wph.info.model.OwnerInfo;

import java.util.Date;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-30 11:14
 * =============================================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class OwnerTest {
    @Autowired
    private OwnerInfoMapper ownerInfoMapper;

    @Test
    public void test(){
        OwnerInfo ownerInfo = new OwnerInfo();
        ownerInfo.setName("test");
        ownerInfoMapper.insert(ownerInfo);
        ownerInfoMapper.selectAll();
        ownerInfoMapper.deleteByPrimaryKey(1L);
        ownerInfoMapper.selectByPrimaryKey(2L);
    }
}
