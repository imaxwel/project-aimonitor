package per.wph.info.service.impl;

import org.springframework.stereotype.Service;
import per.wph.common.service.BaseServiceImpl;
import per.wph.info.model.CommunityInfo;
import per.wph.info.model.relation.CommunityOwner;
import per.wph.info.service.CommunityService;

import java.util.List;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-01 13:54
 * =============================================
 */
@Service
public class CommunityServiceImpl extends BaseServiceImpl implements CommunityService {

    @Override
    public List<CommunityInfo> getAllCommunityInfo() {
        return communityInfoMapper.selectAllUnDetail();
    }

    @Override
    public int saveCommunityOwner(CommunityOwner communityOwner) {
        return communityOwnerMapper.insert(communityOwner);
    }
}
