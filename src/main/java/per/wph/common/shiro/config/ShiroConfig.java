package per.wph.common.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import per.wph.common.shiro.DefaultShiroRealm;
import per.wph.common.shiro.ShiroFilterFactory;

@Configuration
public class ShiroConfig {

    /**
     *配置thymeleaf模板标签
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    /**
     * 配置密码匹配器
     * @return
     */
    @Bean
    public HashedCredentialsMatcher matcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("SHA-256");
        matcher.setHashIterations(2);
        return matcher;
    }

    /**
     * 配置realm
     * @param matcher
     * @return
     */
    @Bean
    public DefaultShiroRealm realm(HashedCredentialsMatcher matcher){
        DefaultShiroRealm realm = new DefaultShiroRealm();
        realm.setCredentialsMatcher(matcher);
        return realm;
    }

    /**
     * 被指安全管理器
     * @param realm
     * @return
     */
    @Bean
    public SecurityManager securityManager(DefaultShiroRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }


    /**
     * 配置过滤工厂
     * @return
     */
    @Bean
    public ShiroFilterFactory shiroFilterFactory(){
        return new ShiroFilterFactory();
    }

    @Autowired
    private ShiroFilterFactory shiroFilterFactory;

    /**
     * 配置过滤类
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean bean = shiroFilterFactory.create(securityManager);
        return bean;
    }


}
