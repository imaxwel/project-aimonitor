package per.wph.mybatis;

import org.apache.tomcat.util.modeler.FeatureInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.common.exception.DllUnavailableException;
import per.wph.engine.mapper.FaceFeatureMapper;
import per.wph.engine.model.FaceFeature;
import per.wph.engine.servicce.FeatureService;

import java.io.IOException;
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
    @Autowired
    private FeatureService featureService;
    @Test
    public void testDAO() throws DllUnavailableException, IOException {
        featureService.saveFeatureInfoByImage("C:\\Users\\wu\\Desktop\\20180131212814.jpg");
    }
}
