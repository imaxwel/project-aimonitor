package per.wph.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wph.common.DefaultMsg;
import per.wph.common.MsgTemplate;
import per.wph.common.handler.ApiResult;
import per.wph.common.handler.ApiResultGenerator;
import per.wph.common.shiro.util.LoginUtil;
import per.wph.common.shiro.util.PasswordUtil;
import per.wph.info.model.UserInfo;
import per.wph.info.service.UserService;

@Controller
public class BasePageController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginUtil loginUtil;
    @Autowired
    private PasswordUtil passwordUtil;

    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "regist";
    }

    @RequestMapping(value="/unauthorized")
    public String unauthorized(){
        return "owner";
    }

    @RequestMapping(value = "/checklogin",method = {RequestMethod.GET})
    @ResponseBody
    public ApiResult checkuser(String username, String password){
        loginUtil.login(username,password);
        return ApiResultGenerator.succssResult("登录成功");
    }

    @RequestMapping("/open/{page}")
    public String open(@PathVariable("page")String page){
        return page;
    }

    @RequestMapping("/regist")
    @ResponseBody
    public ApiResult regist(UserInfo userInfo){
        passwordUtil.encryptPassword(userInfo);
        userService.saveUserInfo(userInfo);
        return ApiResultGenerator.succssResult("注册成功");
    }
}
