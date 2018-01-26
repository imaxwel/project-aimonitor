package per.wph.info.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
@Aspect
public class ServiceAspect {
    @Pointcut("execution(* per.wph.info.service.impl.*.save*(..))")
    public void executeService(){
    }

    //对save方法做统一的异常处理
    @Around("executeService()")
    public Object processSave(ProceedingJoinPoint jp) throws java.lang.Throwable {
        System.out.println("ServiceAspect.processSave()");
        Boolean result = null;
        try {
            result = (Boolean) jp.proceed();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
        return result;
    }
}
