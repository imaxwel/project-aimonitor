package per.wph.info.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import per.wph.common.ApiResult;
import per.wph.common.generator.ApiResultGenerator;
import per.wph.common.generator.RandomGenerator;
import per.wph.info.model.UserInfo;
import per.wph.info.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController extends BaseController{
    //设置默认的验证码超时时间为两分钟
    private final static Long OVERTIME = 2*60000L;
    private final static String IDCODE = "identityCode";
    private final static String IDCODE_AVAILABLE_TIME = "identityCodeAvailableTime";

    @RequestMapping(value="/sendIdenCode")
    public @ResponseBody ApiResult sendIdenCode(HttpSession httpSession){
        int iden = RandomGenerator.idenCode();
        System.out.println("iden==" + iden);
        httpSession.setAttribute(IDCODE, iden);
        httpSession.setAttribute(IDCODE_AVAILABLE_TIME, System.currentTimeMillis() + OVERTIME);
        return ApiResultGenerator.succssResult("验证码发送成功");
    }

    @RequestMapping(value="/regist")
    public @ResponseBody ApiResult regist(HttpSession httpSession, HttpServletRequest request){
        Long currentTime = System.currentTimeMillis();
        if(httpSession.getAttribute(IDCODE_AVAILABLE_TIME)!=null
                && currentTime>(Long)httpSession.getAttribute(IDCODE_AVAILABLE_TIME)){
            return ApiResultGenerator.errorResult("验证码超时",null);
        }
        UserInfo userInfo = new UserInfo();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        Integer iden = Integer.valueOf(request.getParameter("iden"));
        Integer idencode = (Integer) httpSession.getAttribute(IDCODE);
        if(idencode.equals(iden)){
            passwordUtil.encryptPassword(userInfo);
            userService.saveUserInfo(userInfo);
            loginUtil.login(username,password,Boolean.TRUE);
            return ApiResultGenerator.succssResult("注册成功");
        }
        return ApiResultGenerator.errorResult("注册失败",null);
    }

    @RequestMapping(value = "/permit/get",method = {RequestMethod.GET})
    public @ResponseBody UserInfo getUserInfo(Long id){
        return userService.getUserInfoById(id);
    }

    @RequestMapping(value = "/permit/getAll")
    public @ResponseBody List<UserInfo> getAll(){
        return userService.getAll();
    }

}
