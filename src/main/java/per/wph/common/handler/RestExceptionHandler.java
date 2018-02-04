package per.wph.common.handler;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import per.wph.common.ApiResult;
import per.wph.common.exception.ImgUnavailableException;
import per.wph.common.generator.ApiResultGenerator;

import java.sql.SQLException;

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

    @ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
    @ResponseStatus
    public ApiResult sqlExceptionHandle(Exception e){
        LOGGER.error(e.getMessage(),e);
        return ApiResultGenerator.errorResult("账号已存在",e);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus
    public ApiResult nullPoninterExceptionHandle(Exception e){
        LOGGER.error(e.getMessage(),e);
        return ApiResultGenerator.errorResult("请确认输入正确的值",e);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus
    public ApiResult numberFormatExceptionHandle(Exception e){
        LOGGER.error(e.getMessage(),e);
        return ApiResultGenerator.errorResult("请输入数字",e);
    }

    @ExceptionHandler(ImgUnavailableException.class)
    @ResponseStatus
    public ApiResult imgUnavailableExceptionHandle(Exception e){
        LOGGER.error(e.getMessage(),e);
        return ApiResultGenerator.errorResult("图片识别失败",e);
    }
}
