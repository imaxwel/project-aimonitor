package per.wph.common.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BasePageController {
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        System.out.println("return login");
        return "regist";
    }

    @RequestMapping(value = "/checklogin",method = {RequestMethod.GET})
    public String checkuser(String username,String password){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken();
            token.setUsername(username);
            token.setPassword(password.toCharArray());
            token.setRememberMe(Boolean.FALSE);
            subject.login(token);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "index";
    }


    @RequestMapping("/open/{page}")
    @RequiresRoles("管理员")
    public String open(@PathVariable("page")String page){
        return page;
    }

    @RequestMapping("/common/regist")
    public String regist(){
        return "regist";
    }
}
