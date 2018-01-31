package per.wph.info.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * =============================================
 * 处理Service层中的异常
 * @author wu
 * @create 2018-01-31 9:01
 * =============================================
 */
@Component
@Aspect
public class ServiceExceptionAspect {

    @Pointcut("execution(public * per.wph.info.service..*.save*(..)) ")
    public void sqlException(){};

    /**
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("sqlException()")
    public Object sqlExceptionHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            proceedingJoinPoint.proceed();
        }catch (SQLException e){
            return false;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
        return true;
    }
}
