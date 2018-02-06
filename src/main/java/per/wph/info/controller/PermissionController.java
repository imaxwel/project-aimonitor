package per.wph.info.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.wph.common.controller.BaseController;
import per.wph.info.model.SysPermission;
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
    public Set<SysPermission> getPermissions(){
        return permissionService.getSysPermissionsByUsername((String) SecurityUtils.getSubject().getPrincipal());
    }

    @RequestMapping("ownauth")
    public String getOwnAuth(Model model){
        Set<SysPermission> permissions = permissionService.getSysPermissionsByUsername((String)SecurityUtils.getSubject().getPrincipal());
        model.addAttribute("permissions",permissions);
        return "ownauth";
    }
}
