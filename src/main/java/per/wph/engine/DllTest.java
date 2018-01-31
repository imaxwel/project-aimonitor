package per.wph.engine;

import per.wph.engine.clib.EngineDll;
import per.wph.engine.clib.FaceModel;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-27 23:29
 * =============================================
 */
public class DllTest {
    public static void main(String[] args) {
        EngineDll cLibrary = EngineDll.INSTANCE;

        FaceModel.ByValue faceModel =new FaceModel.ByValue();
        faceModel.lFeatureSize = 500;
        faceModel.pbFeature = "abc\0";
        cLibrary.testStruct(faceModel);
        cLibrary.testStruct2(faceModel);

        cLibrary.engineInit();
        String result1 = cLibrary.getFeatureByImage("C:\\Users\\wu\\Desktop\\1436597244_849347.jpg");
        String result2 = cLibrary.getFeatureByImage("C:\\Users\\wu\\Desktop\\1436597244_849347.jpg");
        FaceModel.ByValue faceModel1 = new FaceModel.ByValue();
        FaceModel.ByValue faceModel2 = new FaceModel.ByValue();
        faceModel1.pbFeature = result1;
        faceModel1.lFeatureSize = 22020;
        faceModel2.pbFeature = result2;
        faceModel2.lFeatureSize = 22020;
        float ret = cLibrary.compareImage(faceModel1,faceModel2);
        System.out.println("比较结果为:" + ret);
        cLibrary.engineUinit();
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
