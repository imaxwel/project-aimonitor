package per.wph.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wph.common.controller.BaseController;
import per.wph.info.model.CommunityInfo;

import java.util.List;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-01 13:50
 * =============================================
 */
@Controller
@RequestMapping("/comm")
public class CommunityController extends BaseController {

    @RequestMapping("/getAll")
    public @ResponseBody List<CommunityInfo> getAll(){
        return communityService.getAllCommunityInfo();
    }
}
