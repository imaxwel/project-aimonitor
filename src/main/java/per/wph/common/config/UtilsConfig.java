package per.wph.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import per.wph.common.util.SpringContentUtil;

@Configuration
public class UtilsConfig {
    /**
     * 配置spring容器工具类
     * @return
     */
    @Bean
    public SpringContentUtil springContentUtil(){
        return new SpringContentUtil();
    }

}
