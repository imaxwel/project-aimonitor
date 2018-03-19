package per.wph.info.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wph.common.ApiResult;
import per.wph.common.annotation.UnTest;
import per.wph.common.controller.BaseController;
import per.wph.common.generator.ApiResultGenerator;
import per.wph.common.util.MapUtil;
import per.wph.info.model.UserInfo;
import per.wph.info.model.VisitorInfo;
import per.wph.info.model.view.OwnerInfoView;
import per.wph.info.model.view.VisitorRegistView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-04 13:50
 * =============================================
 */
@Controller
@RequestMapping("/visitor")
public class VisitorController extends BaseController {
    @RequestMapping("/regist")
    public ApiResult regist(HttpSession session, VisitorRegistView visitorRegistView,Integer[] ids){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        UserInfo userInfo = userService.getUserInfoByUsername(username);
        Long ownId = userInfo.getUid();
        visitorRegistView.setOid(ownId);
        Object faceIdMap = session.getAttribute(FACE_MODEL_LIST);
        if (faceIdMap==null){
            return ApiResultGenerator.errorResult("请上传照片",null);
        }
        List<Long> faceIdList = MapUtil.mapFiltByIds(faceIdMap==null ? null : (Map<Integer,Long>)faceIdMap,ids);
        visitorRegistView.setFaceIdList(faceIdList);
        visitorService.saveVisitorRegistView(visitorRegistView);
        return ApiResultGenerator.succssResult("注册成功");
    }

    @RequestMapping("/permit/getVisitorInfo")
    @ResponseBody
    @UnTest
    public List<VisitorInfo> getVisitorInfo(){
        Object username = SecurityUtils.getSubject().getPrincipal();
        return visitorService.getVisitorInfoListByAdminUsername((String)username);
    }
}
