package per.wph.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wph.common.controller.BaseController;
import per.wph.info.model.SysPermission;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-01-31 23:00
 * =============================================
 */
@Controller
@RequestMapping("/perm")
public class PermissionController extends BaseController {
    @RequestMapping("getPermList")
    @ResponseBody
    public Set<SysPermission> getPermissions(HttpSession session){
        return permissionService.getSysPermissionsByUsername((String) session.getAttribute(USERNAME));
    }

    @RequestMapping("ownauth")
    public String getOwnAuth(HttpSession session,Model model){
        Set<SysPermission> permissions = permissionService.getSysPermissionsByUsername((String)session.getAttribute(USERNAME));
        model.addAttribute("permissions",permissions);
        return "ownauth";
    }
}
