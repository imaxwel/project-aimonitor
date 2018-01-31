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
        String result1 = cLibrary.getFeatureByImage("C:\\Users\\wu\\Desktop\\1436597244_849347.jpg");
        String result2 = cLibrary.getFeatureByImage("C:\\Users\\wu\\Desktop\\1436597244_849347.jpg");
        FaceModel.ByValue faceModel =new FaceModel.ByValue();
        faceModel.lFeatureSize = result1.getBytes("UTF-8").length;
        faceModel.pbFeature = new Memory(result1.getBytes("UTF-8").length);
        faceModel.pbFeature.write(0,result1.getBytes("UTF-8"),0,result1.getBytes("UTF-8").length);
        FaceModel.ByValue faceModel2 =new FaceModel.ByValue();
        faceModel2.lFeatureSize = result2.getBytes("UTF-8").length;
        faceModel2.pbFeature = new Memory(result1.getBytes("UTF-8").length);
        faceModel.pbFeature.write(0,result2.getBytes("UTF-8"),0,result2.getBytes("UTF-8").length);
        float ret = cLibrary.compareImage(faceModel,faceModel2);
        System.out.println("比较结果为:" + ret);
//        cLibrary.testStruct(faceModel);
//        cLibrary.testStruct2(faceModel);

//        cLibrary.engineInit();
//        String result1 = cLibrary.getFeatureByImage("C:\\Users\\wu\\Desktop\\1436597244_849347.jpg");
//        String result2 = cLibrary.getFeatureByImage("C:\\Users\\wu\\Desktop\\1436597244_849347.jpg");
//        FaceModel.ByValue faceModel1 = new FaceModel.ByValue();
//        FaceModel.ByValue faceModel2 = new FaceModel.ByValue();
//        faceModel1.pbFeature = result1;
//        faceModel1.lFeatureSize = 22020;
//        faceModel2.pbFeature = result2;
//        faceModel2.lFeatureSize = 22020;
//        float ret = cLibrary.compareImage(faceModel1,faceModel2);
//        System.out.println("比较结果为:" + ret);
//        cLibrary.engineUinit();
    }

    private static String StrToBinstr(String str) {
        char[] strChar = str.toCharArray();
        String result = "";
        for (int i = 0; i < strChar.length; i++) {
            result += Integer.toBinaryString(strChar[i]) + " ";
        }
        return result;
    }

}
