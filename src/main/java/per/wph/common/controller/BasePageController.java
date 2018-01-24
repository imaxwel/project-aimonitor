package per.wph.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasePageController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/open/{page}")
    public String open(@PathVariable("page")String page){
        return page;
    }

    @RequestMapping("/common/regist")
    public String regist(){
        return "regist";
    }
}
