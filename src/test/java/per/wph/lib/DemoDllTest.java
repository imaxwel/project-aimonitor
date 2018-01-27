package per.wph.lib;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import per.wph.common.util.ResourceLoaderUtil;
import per.wph.engine.clib.DemoDll;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-27 23:20
 * =============================================
 */
@RunWith(JUnit4.class)
public class DemoDllTest {

    @Test
    public void test1(){
        int ret = DemoDll.INSTANCE.init();
        System.out.println(ret);
        ret = DemoDll.INSTANCE.load("C:\\Users\\wu\\Desktop\\timg.jpg");
        System.out.println(ret);
        ret = DemoDll.INSTANCE.uninit();
        System.out.println(ret);
    }

    @Test
    public void test2(){
        System.out.println(ResourceLoaderUtil.getResourceFilePathWithPackage("dll","Demo.dll"));
    }
}
