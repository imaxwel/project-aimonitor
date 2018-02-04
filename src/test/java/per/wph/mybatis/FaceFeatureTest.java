package per.wph.mybatis;

import org.apache.tomcat.util.modeler.FeatureInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.common.exception.DllUnavailableException;
import per.wph.common.exception.ZeroFaceException;
import per.wph.engine.mapper.FaceFeatureMapper;
import per.wph.engine.model.FaceFeature;
import per.wph.engine.model.view.OwnerFaceFeatureView;
import per.wph.engine.model.view.VisitorFaceFeatureView;
import per.wph.engine.servicce.FeatureService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public void testDAO() throws DllUnavailableException, IOException, ZeroFaceException {
        featureService.saveFeatureInfoByImage("C:\\Users\\wu\\Desktop\\20180131212814.jpg");
    }

    @Test
    public void testDAO2(){
        List<OwnerFaceFeatureView> faceFeatureViews = faceFeatureMapper.selectOwnerFaceFeatureView(1L,1L);
    }

    @Test
    public void testDAO3(){
        List<OwnerFaceFeatureView> faceFeatureViews = faceFeatureMapper.selectOwnerFaceFeatureView(null,1L);
    }

    @Test
    public void testDAO4(){
        List<OwnerFaceFeatureView> faceFeatureViews = faceFeatureMapper.selectOwnerFaceFeatureView(1L,null);
    }

    @Test
    public void testDAO5(){
        List<OwnerFaceFeatureView> faceFeatureViews = faceFeatureMapper.selectOwnerFaceFeatureView(null,null);
    }

    @Test
    public void testDAO6(){
        List<VisitorFaceFeatureView> visitorFaceFeatureViews = faceFeatureMapper.selectVisitorFaceFeatureView(1L,1L);
    }

    @Test
    public void testDAO7(){
        List<VisitorFaceFeatureView> visitorFaceFeatureViews = faceFeatureMapper.selectVisitorFaceFeatureView(1L,null);
    }

    @Test
    public void testDAO8(){
        List<VisitorFaceFeatureView> visitorFaceFeatureViews = faceFeatureMapper.selectVisitorFaceFeatureView(null,1L);
    }

    @Test
    public void testService() throws DllUnavailableException {
        FaceFeature faceFeature = faceFeatureMapper.selectAll().get(0);
        List<OwnerFaceFeatureView> ownerFaceFeatureViews = new ArrayList<OwnerFaceFeatureView>();
        featureService.isOwner(faceFeature.getFeature(),1L,1L,false,ownerFaceFeatureViews);
    }
}
