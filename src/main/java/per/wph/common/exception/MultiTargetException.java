package per.wph.common.exception;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-01 12:12
 * =============================================
 */
public class MultiTargetException extends BaseException {

    public MultiTargetException() {
    }

    public MultiTargetException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        System.out.println(this.getMessage());
    }


}
