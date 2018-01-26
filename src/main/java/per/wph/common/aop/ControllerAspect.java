package per.wph.common.aop;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
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
import per.wph.common.DefaultMsg;
import per.wph.common.MsgTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
@Aspect
public class ControllerAspect {
    @Pointcut("execution(* per.wph.common.controller.BasePageController.regist*(..))")
    public void executeService(){
    }

    //对registe方法做异常处理
    @Around("executeService()")
    public Object processSave(ProceedingJoinPoint jp) throws java.lang.Throwable {
        System.out.println("ControllerAspect.processSave()");
        DefaultMsg result = null;
        try {
            result = (DefaultMsg) jp.proceed();
        }catch (Exception e){
            result = new DefaultMsg();
            result.setStatus(DefaultMsg.tag.FALSE.status());
            result.setMessage("FALSE:" + e.getClass().getName());
        }finally {
            return result;
        }
    }
}
