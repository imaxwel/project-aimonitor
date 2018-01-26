package per.wph.common;

import per.wph.common.MsgTemplate;

public class DefaultMsg implements MsgTemplate{
    private String message = tag.DEFAULT.name();
    private String status = tag.DEFAULT.status();

    public DefaultMsg() {
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
