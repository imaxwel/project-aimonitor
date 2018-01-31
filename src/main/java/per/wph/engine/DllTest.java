package per.wph.engine;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import per.wph.engine.clib.EngineDll;
import per.wph.engine.clib.FaceModel;

import java.io.*;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-27 23:29
 * =============================================
 */
public class DllTest {
    public static void main(String[] args) throws IOException {
        EngineDll cLibrary = EngineDll.INSTANCE;
        cLibrary.engineInit();
        FaceModel.ByValue faceModel1;
        FaceModel.ByValue faceModel2;
        faceModel1 = cLibrary.getFeatureByImage("C:\\Users\\wu\\Desktop\\1436597244_849347.jpg");
        faceModel2 = cLibrary.getFeatureByImage("C:\\Users\\wu\\Desktop\\1436597244_849347.jpg");
        float ret = cLibrary.compareImage(faceModel1,faceModel2);
    }

}
