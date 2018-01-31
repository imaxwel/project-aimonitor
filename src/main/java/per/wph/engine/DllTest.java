package per.wph.engine;

import per.wph.engine.clib.EngineDll;

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
//        cLibrary.FDinit();
//        cLibrary.FRinit();
//        cLibrary.loadimage(123,"C:\\Users\\wu\\Desktop\\1436597244_849347.jpg");
//        cLibrary.FD(123);
//        cLibrary.FR(123);
//        String result = cLibrary.Feature(123);
//        System.out.println(result);
//
//        cLibrary.loadimage(456,"C:\\Users\\wu\\Desktop\\timg.jpg");
//        cLibrary.FD(456);
//        cLibrary.FR(456);
//        String result2 = cLibrary.Feature(456);
//        System.out.println(result2);
//
//        cLibrary.loadimage(789,"C:\\Users\\wu\\Desktop\\timg.jpg");
//        cLibrary.FD(789);
//        cLibrary.FR(789);
//        String result3 = cLibrary.Feature(789);
//        System.out.println(result3);
        cLibrary.engineInit();
        String result = cLibrary.getFeatureByImage("C:\\Users\\wu\\Desktop\\timg.jpg");
        result.getBytes();
        System.out.println(result);
    }

}
