package per.wph.engine.servicce.impl;

import org.apache.tomcat.util.modeler.FeatureInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.wph.engine.clib.EngineDll;
import per.wph.engine.mapper.FaceFeatureMapper;
import per.wph.engine.model.FaceFeature;
import per.wph.engine.servicce.FeatureService;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-30 16:43
 * =============================================
 */
@Service
public class FeatureServiceImpl implements FeatureService {
    @Autowired
    private FaceFeatureMapper faceFeatureMapper;

    @Override
    @Transactional
    public boolean saveFeatureInfo(FaceFeature faceFeature) {
        try{
            faceFeatureMapper.insert(faceFeature);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean saveFeatureInfoByImage(Long id,String filePath) {
        FaceFeature faceFeature = new FaceFeature();
        EngineDll.INSTANCE.getFeatureByImage(filePath);
        return false;
    }
}
