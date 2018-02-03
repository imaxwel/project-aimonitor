package per.wph.info.service;

import per.wph.common.exception.MultiTargetException;
import per.wph.info.model.OwnerInfo;
import per.wph.info.model.view.OwnerInfoView;
import per.wph.info.model.view.OwnerRegistView;

import java.util.List;

public interface OwnerService extends BaseService {
    int saveOwnerInfo(OwnerInfo ownerInfo);

    /**
     * 根据管理员名称 获得用户信息和楼房信息
     * @param username
     * @return
     * @throws MultiTargetException 查询超过多个对象时抛出异常
     */
    List<OwnerInfoView> getOwnerAndBuildingListByAdminUsername(String username) throws MultiTargetException;

    int saveOwnerRegistView(OwnerRegistView ownerRegistView,Boolean isAdmin);
}
