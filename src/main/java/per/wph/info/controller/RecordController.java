package per.wph.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wph.common.controller.BaseController;
import per.wph.info.model.view.RecordOwnerView;

import javax.servlet.http.HttpSession;
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
    @RequestMapping("/permit/getOwner")
    public @ResponseBody List<RecordOwnerView> getOwner(HttpSession session,int pageNum,int pageSize) {
        Optional username = Optional.of(session.getAttribute(USERNAME));
        return recordService.getAllOwnerRecordByUsername((String) username.get(),pageNum,pageSize);
    }


}
