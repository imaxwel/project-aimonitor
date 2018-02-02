package per.wph.info.service;

import per.wph.info.model.CommunityInfo;

import java.util.List;

public interface CommunityService extends BaseService {
    List<CommunityInfo> getAllCommunityInfo();
}
