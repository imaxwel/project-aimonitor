package per.wph.common.shiro.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.Sha256CredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import per.wph.common.shiro.DefaultShiroRealm;
import per.wph.common.shiro.ShiroFilterFactory;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public HashedCredentialsMatcher matcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("SHA-256");
        matcher.setHashIterations(2);
        return matcher;
    }

    @Bean
    public DefaultShiroRealm realm(HashedCredentialsMatcher matcher){
        DefaultShiroRealm realm = new DefaultShiroRealm();
        realm.setCredentialsMatcher(matcher);
        return realm;
    }

    @Bean
    public SecurityManager securityManager(DefaultShiroRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }


    @Bean
    public ShiroFilterFactory shiroFilterFactory(){
        return new ShiroFilterFactory();
    }

    @Autowired
    private ShiroFilterFactory shiroFilterFactory;

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean bean = shiroFilterFactory.create(securityManager);
        return bean;
    }


}
