package exceptions;

public class IncorrectFileSizeException extends Exception {

    public IncorrectFileSizeException(String message) {
        super(message);
    }

    public IncorrectFileSizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
