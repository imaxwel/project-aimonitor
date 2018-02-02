package per.wph.common.exception;

/**
 * =============================================
 *
 * @author wu
 * @create 2018-02-01 14:59
 * =============================================
 */
public class DllUnavailableException extends BaseException {


    public DllUnavailableException() {
    }

    public DllUnavailableException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        System.out.println(this.getMessage());
    }

}
