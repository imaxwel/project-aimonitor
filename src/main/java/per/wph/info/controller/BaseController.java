package per.wph.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import per.wph.common.shiro.util.LoginUtil;
import per.wph.common.shiro.util.PasswordUtil;
import per.wph.info.service.PermissionService;
import per.wph.info.service.UserService;

public class BaseController {
    //设置默认的验证码超时时间为两分钟
    protected final static Long OVERTIME = 2*60000L;
    protected final static String IDCODE = "identityCode";
    protected final static String IDCODE_AVAILABLE_TIME = "identityCodeAvailableTime";
    protected final static String USERNAME = "username";
    protected final static String LOGINTIME = "logintime";

    @Autowired
    protected LoginUtil loginUtil;
    @Autowired
    protected PasswordUtil passwordUtil;
    @Autowired
    protected UserService userService;
    @Autowired
    protected PermissionService permissionService;
}
