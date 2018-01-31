package per.wph.info.service;

import org.apache.catalina.User;
import per.wph.info.model.OwnerInfo;
import per.wph.info.model.UserInfo;

public interface OwnerService extends BaseService {
    int saveOwnerInfo(OwnerInfo ownerInfo);
}
