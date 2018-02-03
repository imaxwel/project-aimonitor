package per.wph.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wph.common.controller.BaseController;
import per.wph.info.model.BuildingInfo;

import java.util.List;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-01 14:05
 * =============================================
 */
@Controller
@RequestMapping("/buil")
public class BuildingController extends BaseController {

    @RequestMapping("/getByCid")
    @ResponseBody
    public List<BuildingInfo> getBuild(Long cid){
        return buildingService.getBuildingInfoListByCommunityId(cid);
    }

}
