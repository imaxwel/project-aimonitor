package per.wph.common.annotation;

import java.lang.annotation.*;

/**
 * 移动端独占的接口方法注解
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface MobileOnly {
}
