package per.wph.engine.servicce;

import org.springframework.stereotype.Service;
import per.wph.common.exception.DllUnavailableException;
import per.wph.engine.model.FaceFeature;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FeatureService {

    Long saveFeatureInfo(FaceFeature faceFeature);

    Long saveFeatureInfoByImage(String filePath) throws DllUnavailableException, IOException;
}
