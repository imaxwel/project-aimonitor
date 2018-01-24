package per.wph.info.service;

import per.wph.info.model.UserInfo;

public interface UserInfoService extends BaseService{
    //根据用户ID获取用户
    public UserInfo getById(Long id);
}
