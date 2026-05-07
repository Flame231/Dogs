package exception;

public class WrongPassword extends Exception {
    public WrongPassword(String message) {
        super(message);
    }

    public WrongPassword(String message, Throwable cause) {
        super(message, cause);
    }
}
