package per.wph.common.handler;

import org.apache.shiro.ShiroException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@ResponseBody
public class RestExceptionHandler {
    @ExceptionHandler(ShiroException.class)
    @ResponseStatus
    public ApiResult shiroExceptionHandler(Exception e){
        return ApiResultGenerator.errorResult(e.getMessage(),e);
    }

//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus
//    public ApiResult runtimeExceptionHandler(Exception e){
//        return ApiResultGenerator.errorResult(e.getMessage(),e);
//    }
}
