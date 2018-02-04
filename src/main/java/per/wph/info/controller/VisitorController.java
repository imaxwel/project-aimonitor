package per.wph.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import per.wph.common.ApiResult;
import per.wph.common.controller.BaseController;
import per.wph.common.generator.ApiResultGenerator;
import per.wph.common.util.MapUtil;
import per.wph.info.model.UserInfo;
import per.wph.info.model.VisitorInfo;
import per.wph.info.model.view.VisitorRegistView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
        String username = (String) session.getAttribute(USERNAME);
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
}
