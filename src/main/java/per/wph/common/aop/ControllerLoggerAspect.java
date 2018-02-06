package per.wph.common.aop;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import per.wph.common.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Component
@Aspect
public class ControllerLoggerAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(public * per.wph.common.controller..*.*(..)) " +
            "|| execution(public * per.wph.info.controller..*.*(..))")
    public void webLog(){};

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("-------------------------------------------------------------------------------------");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("-->URL:" + request.getRequestURI());
        logger.info("-->HTTP_METHOD:" + request.getMethod());
        logger.info("-->IP:" + request.getRemoteAddr());
        logger.info("-->SESSION:" + request.getSession().getId());
        logger.info("-->USERNAME:" + SecurityUtils.getSubject().getPrincipal());
        logger.info("-->NOWER_TIME:" + System.currentTimeMillis());
        logger.info("-->CLASS_METHOD:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("-->ARGS:" + Arrays.toString(joinPoint.getArgs()));
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paramName = (String) enu.nextElement();
            logger.info("--->" + paramName + ":" + request.getParameter(paramName));
        }
    }
    @AfterReturning("webLog()")
    public void doAfterReturing(JoinPoint joinPoint){
        logger.info("-------------------------------------------------------------------------------------");
    }

}
