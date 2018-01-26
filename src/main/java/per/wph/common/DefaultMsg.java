package per.wph.common;

import per.wph.common.MsgTemplate;

public class DefaultMsg implements MsgTemplate{
    private String message = tag.DEFAULT.name();
    private String status = tag.DEFAULT.status();

    public DefaultMsg() {
    }

    public DefaultMsg(Boolean result) {
        if(result==Boolean.TRUE){
            this.message = (DefaultMsg.tag.SUCCESS.message());
            this.status = (DefaultMsg.tag.SUCCESS.status());
        }else{
            this.message = (DefaultMsg.tag.FALSE.message());
            this.status = (DefaultMsg.tag.FALSE.status());
        }
    }

    public DefaultMsg(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
