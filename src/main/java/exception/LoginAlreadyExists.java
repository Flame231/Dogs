package exception;

public class LoginAlreadyExists extends RuntimeException {
    public LoginAlreadyExists(String message) {
        super(message);
    }

    public LoginAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }
}
