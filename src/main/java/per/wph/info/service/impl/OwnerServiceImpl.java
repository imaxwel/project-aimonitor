package per.wph.info.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.wph.common.exception.MultiTargetException;
import per.wph.common.service.BaseServiceImpl;
import per.wph.info.model.BuildingInfo;
import per.wph.info.model.OwnerInfo;
import per.wph.info.model.UserInfo;
import per.wph.info.model.relation.BuildingOwner;
import per.wph.info.model.relation.CommunityBuilding;
import per.wph.info.model.relation.CommunityOwner;
import per.wph.info.model.relation.OwnerFeature;
import per.wph.info.model.view.OwnerInfoView;
import per.wph.info.model.view.OwnerRegistView;
import per.wph.info.service.OwnerService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    @Transactional
    public int saveOwnerInfo(OwnerInfo ownerInfo) {
        return ownerInfoMapper.insert(ownerInfo);
    }

    @Override
    public List<OwnerInfoView> getOwnerAndBuildingListByAdminUsername(String username){
        return ownerInfoMapper.selectOwnerAndBuildingInfoByAdminUsername(username);
    }

    @Override
    @Transactional
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

}
