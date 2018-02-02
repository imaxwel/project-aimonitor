package per.wph.info.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wph.common.ApiResult;
import per.wph.common.generator.ApiResultGenerator;

import javax.servlet.http.HttpSession;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-01 14:35
 * =============================================
 */
@Controller
@RequestMapping("owner")
public class OwnerController extends BaseController{
    @RequestMapping("regist")
    @ResponseBody
    public ApiResult regist(HttpSession session,HttpRequest request){
        String username = (String) session.getAttribute(USERNAME);

        return ApiResultGenerator.succssResult("注册成功，请等待审核");
    }
}
