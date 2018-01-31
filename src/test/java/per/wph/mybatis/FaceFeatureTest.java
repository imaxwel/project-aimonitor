package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.engine.mapper.FaceFeatureMapper;
import per.wph.engine.model.FaceFeature;

import java.util.Date;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-30 16:32
 * =============================================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class FaceFeatureTest {

    @Autowired
    private FaceFeatureMapper faceFeatureMapper;
    @Test
    public void testDAO(){
        FaceFeature faceFeature = new FaceFeature();
        faceFeature.setCreateTime(new Date());
        faceFeature.setImageUrl("abc");
        faceFeatureMapper.insert(faceFeature);
    }
}
