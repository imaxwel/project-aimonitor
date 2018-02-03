package per.wph.info.service;


import per.wph.info.model.BuildingInfo;
import per.wph.info.model.relation.BuildingOwner;

import java.util.List;

public interface BuildingService extends BaseService{
    List<BuildingInfo> getBuildingInfoListByCommunityId(Long cid);

    int saveBuildingOwner(BuildingOwner buildingOwner);
}
