package per.wph.common;

public interface MsgTemplate {
    enum tag{
        DEFAULT("DEFAULT MESSAGE","000"),
        SUCCESS("SUCCESS","200"),
        FALSE("FALSE","400"),
        UNKNOWN("UNKNOWN","500");

        private String status;
        private String message;
        private tag(String message,String status){
            this.message = message;
            this.status = status;
        }
        public String status() {
            return status;
        }
        public String message() {
            return message;
        }
    }
}
