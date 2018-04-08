package per.wph.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import per.wph.common.shiro.util.LoginUtil;
import per.wph.common.shiro.util.PasswordUtil;
import per.wph.engine.servicce.FeatureService;
import per.wph.info.service.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {
    //设置默认的验证码超时时间为两分钟
    protected final static Long OVERTIME = 2*60000L;
    protected final static String IDCODE = "identityCode";
    protected final static String IDCODE_AVAILABLE_TIME = "identityCodeAvailableTime";
    protected final static String FACE_MODEL_LIST = "face_model_list";

    @Autowired
    protected LoginUtil loginUtil;
    @Autowired
    protected PasswordUtil passwordUtil;
    @Autowired
    protected UserService userService;
    @Autowired
    protected OwnerService ownerService;
    @Autowired
    protected PermissionService permissionService;
    @Autowired
    protected CommunityService communityService;
    @Autowired
    protected BuildingService buildingService;
    @Autowired
    protected FeatureService featureService;
    @Autowired
    protected VisitorService visitorService;
    @Autowired
    protected RecordService recordService;

}
