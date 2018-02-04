package per.wph.engine;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import org.springframework.stereotype.Component;
import per.wph.common.exception.DllUnavailableException;
import per.wph.engine.clib.EngineDll;
import per.wph.engine.clib.EngineDllManager;
import per.wph.engine.clib.FaceModel;

import java.io.*;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-27 23:29
 * =============================================
 */
@Component
public class DllTest {
    public static void main(String[] args) throws IOException, DllUnavailableException {
        EngineDll cLibrary = EngineDll.INSTANCE;
        cLibrary.engineInit();
        FaceModel.ByValue faceModel1;
        FaceModel.ByValue faceModel2;
        faceModel1 = cLibrary.getFeatureByImage("C:\\Users\\wu\\Desktop\\20180131212814.jpg");
        faceModel2 = cLibrary.getFeatureByImage("C:\\Users\\wu\\Desktop\\20180131215650.jpg");
        byte[] b1 = new byte[faceModel1.lFeatureSize];
        byte[] b2 = new byte[faceModel2.lFeatureSize];
        faceModel1.pbFeature.read(0,b1,0,b1.length);
        faceModel2.pbFeature.read(0,b2,0,b2.length);
        float ret = cLibrary.compareFeature(b1,b1.length,b2,b2.length);
//        float ret = cLibrary.compareImage(faceModel1,faceModel2);
        System.out.println(ret);
        cLibrary.engineUinit();
    }



}
