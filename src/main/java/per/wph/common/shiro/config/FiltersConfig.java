package per.wph.common.shiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import per.wph.common.shiro.filter.PermissionFilter;

@Configuration
public class FiltersConfig {
    @Bean
    @Scope("prototype")
    public PermissionFilter permissionFilter(){
        return new PermissionFilter();
    }
}
