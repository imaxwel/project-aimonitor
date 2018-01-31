package per.wph.common.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import per.wph.info.model.UserInfo;

public class LoginUtil {
    public void login(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());
        token.setRememberMe(Boolean.FALSE);
        subject.login(token);
    }

    public boolean login(String username, String password,boolean rememberMe){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());
        token.setRememberMe(rememberMe);
        subject.login(token);
        return true;
    }

    public boolean login(UserInfo userInfo, boolean rememberMe){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(userInfo.getUsername());
        token.setPassword(userInfo.getPassword().toCharArray());
        token.setRememberMe(rememberMe);
        subject.login(token);
        return true;
    }
}
