package per.wph.common.shiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import per.wph.common.shiro.filter.PermissionFilter;

@Configuration
public class FiltersConfig {
    @Bean
    public PermissionFilter permissionFilter(){
        return new PermissionFilter();
    }
}
