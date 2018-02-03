package per.wph.info.service.impl;

import org.springframework.stereotype.Service;
import per.wph.common.service.BaseServiceImpl;
import per.wph.info.model.BuildingInfo;
import per.wph.info.model.relation.BuildingOwner;
import per.wph.info.model.relation.CommunityBuilding;
import per.wph.info.service.BuildingService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-01 14:07
 * =============================================
 */
@Service
public class BuildingServiceImpl extends BaseServiceImpl implements BuildingService{

    @Override
    public List<BuildingInfo> getBuildingInfoListByCommunityId(Long cid) {
        List<BuildingInfo> buildingInfos =new ArrayList<BuildingInfo>();
        List<CommunityBuilding> communityBuildings = communityBuildingMapper.selectByCid(cid);
        Iterator<CommunityBuilding> iterator = communityBuildings.iterator();
        while(iterator.hasNext()){
            buildingInfos.add(buildingInfoMapper.selectByPrimaryKey(iterator.next().getBid()));
        }
        return buildingInfos;
    }

    @Override
    public int saveBuildingOwner(BuildingOwner buildingOwner) {
        return buildingOwnerMapper.insert(buildingOwner);
    }

}
