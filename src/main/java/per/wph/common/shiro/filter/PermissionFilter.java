package per.wph.common.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import per.wph.common.util.SpringContentUtil;
import per.wph.info.service.PermissionService;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class PermissionFilter extends AuthorizationFilter {

    @Autowired
    private PermissionService permissionService;

    private PatternMatcher patternMatcher = new AntPathMatcher();

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        HttpServletRequest httpRequest = ((HttpServletRequest)servletRequest);
        //获取URI
        String uri = httpRequest.getRequestURI();
        //获得subject对象
        Subject subject = getSubject(servletRequest,servletResponse);
        if(subject.getPrincipal()==null){
            //未登录
            return Boolean.FALSE;
        }
        List<String> urls = permissionService.getPermissionUrlsByUsername((String) subject.getPrincipal());
        Iterator<String> iterator = urls.iterator();
        while (iterator.hasNext()){
            if(patternMatcher.matches(iterator.next(),uri)){
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = this.getSubject(request, response);
        if (subject.getPrincipal() == null) {
            this.saveRequestAndRedirectToLogin(request, response);
        } else {
            String unauthorizedUrl = this.getUnauthorizedUrl();
            if (StringUtils.hasText(unauthorizedUrl)) {
                WebUtils.issueRedirect(request, response, unauthorizedUrl);
            } else {
                WebUtils.toHttp(response).sendError(401);
            }
        }
        return Boolean.FALSE;
    }
}
