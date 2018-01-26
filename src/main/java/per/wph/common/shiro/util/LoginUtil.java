package per.wph.common.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import per.wph.common.DefaultMsg;

public class LoginUtil {
    public DefaultMsg login(String username, String password){
        DefaultMsg msg = new DefaultMsg();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken();
            token.setUsername(username);
            token.setPassword(password.toCharArray());
            token.setRememberMe(Boolean.FALSE);
            subject.login(token);
        }catch (Exception e){
            System.out.println(e.getMessage());
            msg.setStatus(DefaultMsg.tag.FALSE.status());
            msg.setMessage(e.getMessage());
            return msg;
        }
        msg.setMessage(DefaultMsg.tag.SUCCESS.message());
        msg.setStatus(DefaultMsg.tag.SUCCESS.status());
        return msg;
    }
}
