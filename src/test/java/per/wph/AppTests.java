package per.wph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.security.PublicKey;

@RunWith(JUnit4.class)
public class AppTests {

	public int value;
	private static void changeStringBuffer(StringBuffer ss1 ,StringBuffer ss2){
		ss1.append("World");
		ss2 = ss1;
	}
	@Test
	public void contextLoads() {
		int i = 1;
		System.out.println(i+++i++);
	}

	public static void main(String[] args) {
		SubClass subClass = new SubClass();
		subClass.test();

		AppTests appTests = new AppTests();
		appTests.test();
		AppTests appTests1 = new SubClass();
		appTests1.test();
	}

	@Test
	public void test(){
		String s1 = "hello";
		String s2 = "hello";
		String s3 = "he" + "llo";
		String s4 = "hel" + new String("lo");
		String s5 = new String("hello");
		String s6 = s5.intern();
		String s7 = "h";
		String s8 = "ello";
		String s9 = s7 + s8;
		System.out.println(s1==s2);//true
		System.out.println(s1==s3);//true
		System.out.println(s1==s4);//false
		System.out.println(s1==s9);//false
		System.out.println(s4==s5);//false
		System.out.println(s1==s6);//true
	}

	@Test
	public void test2(){
		Integer i1=127;
		Integer i2=127;
		System.out.println(i1==i2);
		System.out.println("------------");

		Integer i3=128;
		Integer i4=128;
		System.out.println(i3==i4);
		System.out.println("------------");
	}

	@Test
	public void test3(){
		String s = new String("1");
		s.intern();
		String s2 = "1";
		System.out.println(s == s2);
		System.out.println(s.intern() == s2);

		String s3 = new String("1") + new String("1");
		s3.intern();
		String s4 = "11";
		System.out.println(s3 == s4);
		System.out.println(s3.intern() == s4);
	}

	@Test
	public void test4(){
		Float f1 = new Float(-1.0/0.0);
		Float f2= new Float(-0.0/0.0);
		System.out.println(f1 + "=" + f1.isNaN());
		System.out.println(f2 + "=" + f2.isNaN());
	}
}

class SubClass extends AppTests{
	public int value;
}

