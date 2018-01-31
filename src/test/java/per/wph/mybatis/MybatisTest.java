package per.wph.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import per.wph.info.mapper.UserInfoMapper;
import per.wph.info.model.UserInfo;
import per.wph.info.service.UserService;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class MybatisTest {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserService userService;

    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Test
    public void UserInfoTest1(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("小黄");
        userInfoMapper.insert(userInfo);
        System.out.println(userInfo.getUid());
    }

    @Test
    public void UserInfoServiceTest1(){
        UserInfo userInfo = userService.getUserInfoById(Long.valueOf(1));
        System.out.println(userInfo.getName());
    }

    @Test
    public void TransactionTest1(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("事务测试");
        userInfoMapper.insert(userInfo);
    }

    @Test
    public void UserInfoServiceTest2(){
        UserInfo userInfo = userService.getUserInfoByUsername("1122");
        System.out.println("success");
        System.out.println(userInfo.getName());
    }

    @Test
    public void UserGetRolesTest(){
        Set<Long> ids = userInfoMapper.selectRoleIdsByUsername("1122");
        System.out.println(ids.toArray()[0]);
    }

}
