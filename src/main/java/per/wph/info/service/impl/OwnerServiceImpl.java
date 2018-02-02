package per.wph.info.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.wph.common.exception.MultiTargetException;
import per.wph.info.mapper.OwnerInfoMapper;
import per.wph.info.model.BuildingInfo;
import per.wph.info.model.OwnerInfo;
import per.wph.info.model.UserInfo;
import per.wph.info.model.relation.BuildingOwner;
import per.wph.info.model.relation.CommunityBuilding;
import per.wph.info.model.relation.CommunityOwner;
import per.wph.info.model.view.OwnerView;
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
    public List<OwnerView> getOwnerAndBuildingListByAdminUsername(String username) throws MultiTargetException {
        List<OwnerView> ownerViews = new ArrayList<OwnerView>();
        UserInfo userInfo = userInfoMapper.selectByUsername(username);
        OwnerInfo ownerInfo = ownerInfoMapper.selectByPrimaryKey(userInfo.getUid());
        List<CommunityOwner> communityOwners = communityOwnerMapper.selectByOid(ownerInfo.getOid());
        if(communityOwners.size()>1){
            throw new MultiTargetException("Exist view communityOwner");
        }
        List<CommunityBuilding> communityBuildings = communityBuildingMapper.selectByCid(communityOwners.get(0).getCid());
        Iterator<CommunityBuilding> iterator = communityBuildings.iterator();
        while (iterator.hasNext()){
            CommunityBuilding cb = iterator.next();
            BuildingInfo bi = buildingInfoMapper.selectByPrimaryKey(cb.getBid());
            List<BuildingOwner> buildingOwners = buildingOwnerMapper.selectByOid(cb.getBid());
            Iterator<BuildingOwner> buildingOwnerIterator = buildingOwners.iterator();
            while(buildingOwnerIterator.hasNext()){
                OwnerView ownerView = new OwnerView();
                Long oid = buildingOwnerIterator.next().getOid();
                ownerView.setBuildingInfo(bi);
                ownerView.setOwnerInfo(ownerInfoMapper.selectByPrimaryKey(oid));
                ownerViews.add(ownerView);
            }
        }
        return ownerViews;
    }
}
