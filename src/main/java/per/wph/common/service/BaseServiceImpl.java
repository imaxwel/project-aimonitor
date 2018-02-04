package per.wph.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import per.wph.common.shiro.util.PasswordUtil;
import per.wph.engine.mapper.FaceFeatureMapper;
import per.wph.info.mapper.*;
import per.wph.info.mapper.relation.BuildingOwnerMapper;
import per.wph.info.mapper.relation.CommunityBuildingMapper;
import per.wph.info.mapper.relation.CommunityOwnerMapper;
import per.wph.info.mapper.relation.OwnerFeatureMapper;
import per.wph.info.service.BaseService;

import java.lang.reflect.ParameterizedType;

public class BaseServiceImpl implements BaseService {
    @Autowired
    protected UserInfoMapper userInfoMapper;
    @Autowired
    protected SysPermissionMapper sysPermissionMapper;
    @Autowired
    protected SysRoleMapper sysRoleMapper;
    @Autowired
    protected OwnerInfoMapper ownerInfoMapper;
    @Autowired
    protected BuildingInfoMapper buildingInfoMapper;
    @Autowired
    protected CommunityInfoMapper communityInfoMapper;
    @Autowired
    protected FaceFeatureMapper faceFeatureMapper;
    @Autowired
    protected VisitorInfoMapper visitorInfoMapper;

    @Autowired
    protected CommunityBuildingMapper communityBuildingMapper;
    @Autowired
    protected CommunityOwnerMapper communityOwnerMapper;
    @Autowired
    protected BuildingOwnerMapper buildingOwnerMapper;
    @Autowired
    protected OwnerFeatureMapper ownerFeatureMapper;

    @Autowired
    protected PasswordUtil passwordUtil;
}
