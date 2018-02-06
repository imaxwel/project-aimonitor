package per.wph.common.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import per.wph.common.shiro.filter.PermissionFilter;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShiroFilterFactory {

    @Autowired
    private PermissionFilter permissionFilter;

    /**
     * 默认跳转Url
     */
    private enum DefaultUrl{
        LOGIN("/login"),SUCCESS("/success"),UNAUTHORIZED("/unauthorized");
        private String value;
        private DefaultUrl(String value){
            this.value = value;
        }
        public String value(){
            return this.value;
        }
    }

    /**
     * 默认权限映射
     */
    private enum Authority{
        ANON("anon"),AUTHC("authc"),LOGOUT("logout");
        private String value;
        private Authority(String value){
            this.value = value;
        }
        public String value(){
            return this.value;
        }
    }

    public ShiroFilterFactoryBean create(SecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        setFilter(bean);
        setFilterChain(bean);
        setDefaultPage(bean);
        return bean;
    }

    /**
     * 设置过滤器
     * @param bean
     */
    private void setFilter(ShiroFilterFactoryBean bean){
        Map<String,Filter> filterMap = new HashMap<>();
        filterMap.put("permission",permissionFilter);
        bean.setFilters(filterMap);
    }

    /**
     * 设置ilter过滤链
     * @param bean
     */
    private void setFilterChain(ShiroFilterFactoryBean bean){
        Map<String,String> filter = new LinkedHashMap<>();
        setDefaultFilterChain(filter);
        filter.put("/**",Authority.ANON.value());
        setCustomFilterChain(filter);
        bean.setFilterChainDefinitionMap(filter);
    }

    /**
     * 设置默认的跳转页面
     * @param bean
     */
    private void setDefaultPage(ShiroFilterFactoryBean bean){
        bean.setLoginUrl(DefaultUrl.LOGIN.value());
        bean.setSuccessUrl(DefaultUrl.SUCCESS.value());
        bean.setUnauthorizedUrl(DefaultUrl.UNAUTHORIZED.value());
    }

    /**
     * 设置默认的过滤链
     * @param filter
     */
    private void setDefaultFilterChain(Map<String,String> filter){
        //基本页面显示
        filter.put("/logout",Authority.LOGOUT.value());
        filter.put("/favicon.ico",Authority.ANON.value());
        filter.put("/regist",Authority.ANON.value());
        //注册和登录页面
        filter.put("/user/checkLogin",Authority.ANON.value());
        filter.put("/user/regist",Authority.ANON.value());
        filter.put("/user/sendIdenCode",Authority.ANON.value());
        filter.put("/druid/**",Authority.ANON.value());
        //static资源
        filter.put("/js/**",Authority.ANON.value());
        filter.put("/css/**",Authority.ANON.value());
        filter.put("/image/**",Authority.ANON.value());
    }

    /**
     * 设置用户自定义的过滤链
     * @param filter
     */
    private void setCustomFilterChain(Map<String,String> filter){
        filter.put("/*/permit/**","permission");
    }
}
