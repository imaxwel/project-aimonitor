package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.info.mapper.UserInfoMapper;
import per.wph.info.model.UserInfo;
import per.wph.info.service.UserInfoService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class MybatisTest {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserInfoService userInfoService;

    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Test
    public void UserInfoTest1(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("小黄");
        userInfoMapper.insert(userInfo);
    }

    @Test
    public void UserInfoServiceTest1(){
        UserInfo userInfo = userInfoService.getById(Long.valueOf(1));
        System.out.println(userInfo.getName());
    }

}
