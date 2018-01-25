package per.wph.info.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import per.wph.info.mapper.SysPermissionMapper;
import per.wph.info.mapper.SysRoleMapper;
import per.wph.info.mapper.UserInfoMapper;
import per.wph.info.service.BaseService;

import java.lang.reflect.ParameterizedType;

public class BaseServiceImpl implements BaseService {
    @Autowired
    protected UserInfoMapper userInfoMapper;
    @Autowired
    protected SysPermissionMapper sysPermissionMapper;
    @Autowired
    protected SysRoleMapper sysRoleMapper;
}
