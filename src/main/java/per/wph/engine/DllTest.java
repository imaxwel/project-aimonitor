package per.wph.engine;

import per.wph.engine.clib.DemoDll;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-27 23:29
 * =============================================
 */
public class DllTest {
    public static void main(String[] args) {
        DemoDllTest();
    }

    public static void DemoDllTest(){
        int ret = DemoDll.INSTANCE.init();
        System.out.println(ret);
        ret = DemoDll.INSTANCE.load("C:\\Users\\wu\\Desktop\\timg.jpg");
        System.out.println(ret);
        ret = DemoDll.INSTANCE.uninit();
        System.out.println(ret);
    }
}
