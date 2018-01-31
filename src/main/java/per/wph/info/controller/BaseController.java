package per.wph.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import per.wph.common.shiro.util.LoginUtil;
import per.wph.common.shiro.util.PasswordUtil;
import per.wph.info.service.UserService;

public class BaseController {
    @Autowired
    protected LoginUtil loginUtil;
    @Autowired
    protected PasswordUtil passwordUtil;
    @Autowired
    protected UserService userService;
}
