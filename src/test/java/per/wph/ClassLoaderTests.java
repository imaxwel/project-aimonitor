package per.wph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClassLoaderTests {

    @Test
    public void test1(){
        ClassLoader cl = ClassLoaderTests.class.getClassLoader();
        System.out.println(cl.toString());
//        ClassLoader cl2 = int.class.getClassLoader();
        System.out.println(cl.getParent().toString());
        System.out.println(cl.getParent().getParent().toString());
    }
}
