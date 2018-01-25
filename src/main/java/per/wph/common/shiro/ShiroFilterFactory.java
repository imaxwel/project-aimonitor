package per.wph.common.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import per.wph.common.shiro.filter.PermissionFilter;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShiroFilterFactory {

    public static final String LOGIN = "/login";
    public static final String SUCCESS = "/index";
    public static final String Unauthorized = "/index";

    public static ShiroFilterFactoryBean create(SecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        setFilter(bean);
        setFilterChain(bean);
        setDefaultPage(bean);
        return bean;
    }

    private static void setFilter(ShiroFilterFactoryBean bean){
        Map<String,Filter> filterMap = new HashMap<>();
        filterMap.put("permission",new PermissionFilter());
        bean.setFilters(filterMap);
    }
    private static void setFilterChain(ShiroFilterFactoryBean bean){
        Map<String,String> filter = new LinkedHashMap<>();
        setDefaultFilterChain(filter);
        setCustomFilterChain(filter);
        filter.put("/permit/**","permission");
        filter.put("/**","authc");
        bean.setFilterChainDefinitionMap(filter);
    }

    private static void setDefaultPage(ShiroFilterFactoryBean bean){
        bean.setLoginUrl(LOGIN);
        bean.setSuccessUrl(SUCCESS);
        bean.setUnauthorizedUrl(Unauthorized);
    }

    private static void setDefaultFilterChain(Map<String,String> filter){
        filter.put("/logout","logout");
        filter.put("/favicon.ico","anon");//spring的页面图标
        filter.put("/checklogin","anon");
        filter.put("/test","anon");
        filter.put("/druid/**","anon");
        filter.put("/js/**","anon");
        filter.put("/css/**","anon");
        filter.put("/image/**","anon");
    }

    private static void setCustomFilterChain(Map<String,String> filter){

    }
}