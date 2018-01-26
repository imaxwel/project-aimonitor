package per.wph.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import per.wph.common.util.SpringContentUtil;

@Configuration
public class UtilsConfig {
    @Bean
    public SpringContentUtil springContentUtil(){
        return new SpringContentUtil();
    }

}
