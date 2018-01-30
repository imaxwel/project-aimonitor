package per.wph.common.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
        return "owner";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/regist")
    public String regist(){
        return "login";
    }

    @RequestMapping(value="/unauthorized")
    public String unauthorized(){
        return "login";
    }

    @RequestMapping(value="/success")
    public String owner(){
        return "owner";
    }

    @RequestMapping(value = "/checklogin")
    @ResponseBody
    public ApiResult checkuser(String username, String password, boolean rememberMe){
        loginUtil.login(username,password,rememberMe);
        return ApiResultGenerator.succssResult("登录成功");
    }

    @RequestMapping("/checkregist")
    @ResponseBody
    public ApiResult regist(UserInfo userInfo){
        passwordUtil.encryptPassword(userInfo);
        userService.saveUserInfo(userInfo);
        return ApiResultGenerator.succssResult("注册成功");
    }

    /**
     * 基本authc权限页面跳转页面
     * @param page
     * @return
     */
    @RequestMapping("/base/{page}")
    public String open(@PathVariable("page")String page){
        return page;
    }
}
