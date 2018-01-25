package per.wph.mybatis;

import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.apache.shiro.util.RegExPatternMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class AntPathMatcherTest {
    private PatternMatcher patternMatcher = new AntPathMatcher();

    private PatternMatcher patternMatcher2 = new RegExPatternMatcher();
    @Test
    public void test1(){
        System.out.println(patternMatcher.matches("/permit/user/get?id=1","/permit/**"));
        System.out.println(patternMatcher.matches("/permit/**","/permit/user/get?id=1"));
        System.out.println(patternMatcher2.matches("/permit/user/get?id=1","/permit/**"));
    }
}
