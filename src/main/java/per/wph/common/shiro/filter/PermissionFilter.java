package per.wph.common.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import per.wph.common.util.SpringContentUtil;
import per.wph.info.service.PermissionService;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

public class PermissionFilter extends AccessControlFilter {

    private PermissionService permissionService;

    private PatternMatcher patternMatcher = new AntPathMatcher();

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        if(permissionService==null){
            permissionService = SpringContentUtil.getApplicationContext().getBean(PermissionService.class);
        }
        HttpServletRequest httpRequest = ((HttpServletRequest)servletRequest);
        String uri = httpRequest.getRequestURI();//获取URI
        Subject subject = getSubject(servletRequest,servletResponse);//获得subject对象
        if(subject==null){
            //未登录
            return Boolean.FALSE;
        }
        List<String> urls = permissionService.getPermissionUrlsByUsername((String) subject.getPrincipal());
        Iterator<String> iterator = urls.iterator();
        while (iterator.hasNext()){
            if(patternMatcher.matches(uri,iterator.next())){
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return Boolean.FALSE;
    }
}
