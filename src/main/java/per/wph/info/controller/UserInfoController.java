package per.wph.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import per.wph.info.model.UserInfo;
import per.wph.info.service.UserInfoService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController extends BaseController{
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    public UserInfo getUserInfo(Long id){
        return userInfoService.getById(id);
    }

    @RequestMapping(value = "/getAll")
    public List<UserInfo> getAll(){
        return userInfoService.getAll();
    }
}
