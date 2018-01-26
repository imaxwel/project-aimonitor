package per.wph.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import per.wph.common.DefaultMsg;
import per.wph.info.model.UserInfo;
import per.wph.info.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/permit/user")
public class UserInfoController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    public UserInfo getUserInfo(Long id){
        return userService.getUserInfoById(id);
    }

    @RequestMapping(value = "/getAll")
    public List<UserInfo> getAll(){
        return userService.getAll();
    }
}
