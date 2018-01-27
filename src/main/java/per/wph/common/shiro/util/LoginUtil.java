package per.wph.common.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import per.wph.common.DefaultMsg;

public class LoginUtil {
    public void login(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());
        token.setRememberMe(Boolean.FALSE);
        subject.login(token);
    }
}
