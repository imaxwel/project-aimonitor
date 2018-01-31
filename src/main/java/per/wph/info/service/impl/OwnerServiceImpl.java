package per.wph.info.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.wph.info.model.OwnerInfo;
import per.wph.info.model.UserInfo;
import per.wph.info.service.OwnerService;

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
}
