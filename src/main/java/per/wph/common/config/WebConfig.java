package per.wph.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * =============================================
 * 自定义配置类实现JavaBean注解形式配置
 * @author wu
 * @create 2018-01-27 16:49
 * =============================================
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
    /**
     * 配置Cors跨域访问策略
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //允许跨域url
                .allowedOrigins("*")
                //允许跨域session
                .allowCredentials(true)
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
                .maxAge(3600);
    }
}
