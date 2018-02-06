package per.wph.info.service;

import per.wph.common.exception.MultiTargetException;
import per.wph.info.model.OwnerInfo;
import per.wph.info.model.view.OwnerInfoView;
import per.wph.info.model.view.OwnerRegistView;

import java.util.List;

public interface OwnerService extends BaseService {

    /**
     * 根据管理员名称 获得用户信息和楼房信息
     * @param username
     * @return
     * @throws MultiTargetException 查询超过多个对象时抛出异常
     */
    List<OwnerInfoView> getOwnerInfoViewListByAdminUsername(String username);

    /**
     *  保存业主信息
     * @param ownerRegistView
     * @param isAdmin
     * @return
     */
    int saveOwnerRegistView(OwnerRegistView ownerRegistView,Boolean isAdmin);

    /**
     * 删除业主相关注册信息
     * @param ownerRegistView
     * @return
     */
    int deleteOwnerRegistView(OwnerRegistView ownerRegistView);

    /**
     * 根据用户名获得业主信息
     * @param username
     * @return
     */
    OwnerInfoView getOwnerInfoViewByUsername(String username);

    /**
     * 通过业主的审核申请
     * @param oid
     * @return
     */
    int accessOwnerRegist(Long oid);

    /**
     *  不通过业主的审核申请
     * @param oid
     * @return
     */
    int unAccessOwnerRegist(Long oid);

    /**
     * 判断业主账号是否可用
     * @return
     */
    boolean ownAvailable(String username);

    /**
     * 判断业主账号是否可用
     * @param oid 根据oid
     * @return
     */
    boolean ownAvailable(Long oid);
}
