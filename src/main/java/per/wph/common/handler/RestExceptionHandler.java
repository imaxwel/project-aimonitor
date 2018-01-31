package per.wph.common.handler;

import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@ResponseBody
public class RestExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(ShiroException.class)
    @ResponseStatus
    public ApiResult shiroExceptionHandler(Exception e){
        LOGGER.error(e.getMessage(),e);
        return ApiResultGenerator.errorResult("登录失败，请检查账号或密码",e);
    }

}
