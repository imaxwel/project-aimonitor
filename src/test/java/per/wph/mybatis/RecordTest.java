package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.info.mapper.RecordOwnerVisitMapper;
import per.wph.info.model.view.RecordOwnerView;

import java.util.List;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-05 10:42
 * =============================================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RecordTest {
    @Autowired
    private RecordOwnerVisitMapper recordOwnerVisitMapper;

    @Test
    public void test1(){
        recordOwnerVisitMapper.selectAllRecordOwnerViewByUsername("1234");
    }

    @Test
    public void test2(){
        List<RecordOwnerView> recordOwnerView = recordOwnerVisitMapper.selectAllRecordOwnerViewByUsername("1234");
    }
}
