package per.wph.im.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import per.wph.im.WiselyMessage;
import per.wph.im.WiselyResponse;

@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("欢迎使用webSocket:" + message.getName());
    }
}
