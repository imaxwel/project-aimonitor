package per.wph.common.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import per.wph.common.shiro.LoginMessage;

public class LoginUtil {
    public LoginMessage login(String username,String password){
        LoginMessage msg = new LoginMessage();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken();
            token.setUsername(username);
            token.setPassword(password.toCharArray());
            token.setRememberMe(Boolean.FALSE);
            subject.login(token);
        }catch (Exception e){
            System.out.println(e.getMessage());
            msg.setStatus(LoginMessage.FALSE);
            msg.setMessage(e.getMessage());
            return msg;
        }
        msg.setStatus(LoginMessage.SUCCESS);
        return msg;
    }
}
