package per.wph.common.shiro;

public class LoginMessage {
    public final static Integer SUCCESS = 200;
    public final static Integer FALSE = 400;
    public final static String DEFAULTMSG = "Login Success";
    private String message = DEFAULTMSG;
    private Integer status = SUCCESS;

    public LoginMessage() {
    }

    public LoginMessage(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
