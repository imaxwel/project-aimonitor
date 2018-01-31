package per.wph.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wph.common.ApiResult;
import per.wph.common.generator.ApiResultGenerator;
import per.wph.common.shiro.util.LoginUtil;
import per.wph.common.shiro.util.PasswordUtil;
import per.wph.info.model.UserInfo;
import per.wph.info.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
        return "regist";
    }

    @RequestMapping(value="/unauthorized")
    public String unauthorized(){
        return "login";
    }

    @RequestMapping(value="/success")
    public String owner(){
        return "owner";
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
