package per.wph.common.annotation;

import java.lang.annotation.*;

/**
 * 标记未测试过的方法
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface UnTest {

}
