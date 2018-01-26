package per.wph.common.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wph.common.shiro.LoginMessage;
import per.wph.common.shiro.util.LoginUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BasePageController {
    @Autowired
    private LoginUtil loginUtil;


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
    public LoginMessage checkuser(String username, String password){
        return loginUtil.login(username,password);
    }


    @RequestMapping("/open/{page}")
    public String open(@PathVariable("page")String page){
        return page;
    }

    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }
}
