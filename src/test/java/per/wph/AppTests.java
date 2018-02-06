package per.wph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.security.PublicKey;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AppTests {

	@Test
	public void contextLoads() {
		int sample[] = new int[10];
		int i,m;
		for(i=0;i<10;i++){
			for(m=1;m<11;m++)
				sample[i] = m;
		}
		System.out.println();
	}

}
