package per.wph.common.shiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import per.wph.common.shiro.util.LoginUtil;
import per.wph.common.shiro.util.PasswordUtil;

@Configuration
public class ShiroUtilsConfig {
    @Bean
    public LoginUtil loginUtil(){
        return new LoginUtil();
    }

    @Bean
    public PasswordUtil passwordUtil(){
        return new PasswordUtil();
    }
}
