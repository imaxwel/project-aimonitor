package per.wph.info.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wph.common.ApiResult;
import per.wph.common.controller.BaseController;
import per.wph.common.generator.ApiResultGenerator;
import per.wph.info.model.UserInfo;
import per.wph.info.model.view.OwnerRegistView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-01 14:35
 * =============================================
 */
@Controller
@RequestMapping("owner")
public class OwnerController extends BaseController {
    @RequestMapping("regist")
    @ResponseBody
    public ApiResult regist(HttpSession session, OwnerRegistView ownerRegistView){
        String username = (String) session.getAttribute(USERNAME);
        UserInfo userInfo = userService.getUserInfoByUsername(username);
        Long ownId = userInfo.getUid();
        ownerRegistView.setOid(ownId);
        Object faceIdList = session.getAttribute(FACE_MODEL_LIST);
        ownerRegistView.setFaceIdList(faceIdList==null ? null : (List<Long>)faceIdList);
        ownerService.saveOwnerRegistView(ownerRegistView, Boolean.FALSE);
        return ApiResultGenerator.succssResult("注册成功，请等待审核");
    }
}
