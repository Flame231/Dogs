package exception;

public class WrongLogin extends RuntimeException {
    public WrongLogin(String message) {
        super(message);
    }

    public WrongLogin(String message, Throwable cause) {
        super(message, cause);
    }
}
