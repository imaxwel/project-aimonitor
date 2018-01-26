package per.wph.common.shiro.util;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;
import per.wph.info.model.UserInfo;

public class PasswordUtil{
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    public void encryptPassword(UserInfo userInfo){
        PasswordService passwordService = new DefaultPasswordService();
        userInfo.setSalt(randomNumberGenerator.nextBytes().toHex());
        Sha256Hash sha = new Sha256Hash(userInfo.getPassword(),userInfo.getCredentialsSalt(),2);
        userInfo.setPassword(sha.toHex());
    }

}
