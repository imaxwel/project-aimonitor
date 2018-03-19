package per.wph.info.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wph.common.annotation.DeBug;
import per.wph.common.controller.BaseController;
import per.wph.info.model.view.RecordOwnerView;

import java.util.List;
import java.util.Optional;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-05 10:06
 * =============================================
 */
@RequestMapping("/record")
@Controller
public class RecordController extends BaseController {
    @RequestMapping("/permit/getOwnerByPage")
    public @ResponseBody List<RecordOwnerView> getOwner(int pageNum,int pageSize) {
        Optional username = Optional.of(SecurityUtils.getSubject().getPrincipal());
        return recordService.getAllOwnerRecordByUsername((String) username.get(),pageNum,pageSize);
    }

    @RequestMapping("/permit/getOwner")
    public @ResponseBody List<RecordOwnerView> getOwner() {
        Optional username = Optional.of(SecurityUtils.getSubject().getPrincipal());
        return recordService.getAllOwnerRecordByUsername((String) username.get());
    }

}
