package per.wph.info.service;

import per.wph.info.model.CommunityInfo;
import per.wph.info.model.relation.CommunityOwner;

import java.util.List;

public interface CommunityService extends BaseService {
    List<CommunityInfo> getAllCommunityInfo();

    int saveCommunityOwner(CommunityOwner communityOwner);
}
