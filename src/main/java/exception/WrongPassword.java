package exception;

public class WrongPassword extends RuntimeException {
    public WrongPassword(String message) {
        super(message);
    }

    public WrongPassword(String message, Throwable cause) {
        super(message, cause);
    }
}
