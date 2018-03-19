package per.wph.info.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.wph.common.exception.MultiTargetException;
import per.wph.common.service.BaseServiceImpl;
import per.wph.info.model.BuildingInfo;
import per.wph.info.model.OwnerInfo;
import per.wph.info.model.SysRole;
import per.wph.info.model.UserInfo;
import per.wph.info.model.relation.*;
import per.wph.info.model.view.OwnerInfoView;
import per.wph.info.model.view.OwnerRegistView;
import per.wph.info.service.OwnerService;

import javax.management.relation.RoleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-30 11:11
 * =============================================
 */
@Service
public class OwnerServiceImpl extends BaseServiceImpl implements OwnerService {
    @Override
    public List<OwnerInfoView> getOwnerInfoViewListByAdminUsername(String username){
        return ownerInfoMapper.selectOwnerAndBuildingInfoByAdminUsername(username);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveOwnerRegistView(OwnerRegistView ownerRegistView,Boolean isAdmin) {
        OwnerInfo ownerInfo = new OwnerInfo();
        ownerInfo.setOid(ownerRegistView.getOid());
        ownerInfo.setName(ownerRegistView.getName());
        ownerInfo.setIdnumber(ownerRegistView.getIdnumber());
        ownerInfo.setPhone(ownerRegistView.getPhone());
        ownerInfo.setIsadmin(isAdmin);
        ownerInfo.setStatus(OwnerInfo.STATUS.EXAMINE.status());
        ownerInfoMapper.insert(ownerInfo);
        //关联社区用户对象
        CommunityOwner communityOwner = new CommunityOwner();
        communityOwner.setOid(ownerRegistView.getOid());
        communityOwner.setCid(ownerRegistView.getCid());
        communityOwnerMapper.insert(communityOwner);
        //关联楼层用户对象
        BuildingOwner buildingOwner = new BuildingOwner();
        buildingOwner.setOid(ownerRegistView.getOid());
        buildingOwner.setBid(ownerRegistView.getBid());
        buildingOwner.setNum(ownerRegistView.getNum());
        buildingOwnerMapper.insert(buildingOwner);

        Iterator<Long> featureIds = ownerRegistView.getFaceIdList().iterator();
        while (featureIds.hasNext()){
            OwnerFeature ownerFeature = new OwnerFeature();
            ownerFeature.setFid(featureIds.next());
            ownerFeature.setOid(ownerRegistView.getOid());
            ownerFeatureMapper.insert(ownerFeature);
        }
        return 1;
    }

    @Override
    public int deleteOwnerRegistView(OwnerRegistView ownerRegistView) {
        ownerFeatureMapper.deleteByOid(ownerRegistView.getBid());
        communityOwnerMapper.deleteByPrimaryKey(ownerRegistView.getCid(),ownerRegistView.getOid());
        buildingOwnerMapper.deleteByPrimaryKey(ownerRegistView.getBid(),ownerRegistView.getOid());
        ownerInfoMapper.deleteByPrimaryKey(ownerRegistView.getOid());
        return 1;
    }

    @Override
    public OwnerInfoView getOwnerInfoViewByUsername(String username) {
        return ownerInfoMapper.selectByUsername(username);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int accessOwnerRegist(Long oid) {
        OwnerInfo ownerInfo = ownerInfoMapper.selectByPrimaryKey(oid);
        ownerInfo.setStatus(OwnerInfo.STATUS.AVAILABLE.status());
        SysUserRole sysUserRole = sysUserRoleMapper.selectByPrimaryKey(oid);
        sysUserRole.setRoleId(SysRole.SysRoleDefault.OWNER.id());
        sysUserRoleMapper.updateByPrimaryKey(sysUserRole);
        return ownerInfoMapper.updateByPrimaryKey(ownerInfo);
    }

    @Override
    public int unAccessOwnerRegist(Long oid) {
        OwnerInfo ownerInfo = ownerInfoMapper.selectByPrimaryKey(oid);
        ownerInfo.setStatus(OwnerInfo.STATUS.FROZEN.status());
        return ownerInfoMapper.updateByPrimaryKey(ownerInfo);
    }

    @Override
    public boolean ownAvailable(String username) {
        Optional<OwnerInfoView> op = Optional.ofNullable(ownerInfoMapper.selectByUsername(username));
        if(op.isPresent()){
            if(OwnerInfo.STATUS.FROZEN.status().equals(op.get().getStatus())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean ownAvailable(Long oid) {
        Optional<OwnerInfo> op = Optional.ofNullable(ownerInfoMapper.selectByPrimaryKey(oid));
        if(op.isPresent()){
            if(OwnerInfo.STATUS.FROZEN.status().equals(op.get().getStatus())){
                return true;
            }
        }
        return false;
    }

}
