package per.wph.engine.servicce;

import org.springframework.stereotype.Service;
import per.wph.engine.model.FaceFeature;

@Service
public interface FeatureService {

    boolean saveFeatureInfo(FaceFeature faceFeature);

    boolean saveFeatureInfoByImage(Long id,String filePath);
}
