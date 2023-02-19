package exceptions;

public class IncorrectFilePathException extends Exception{
    public IncorrectFilePathException(String message) {
        super(message);
    }

    public IncorrectFilePathException(String message, Throwable cause) {
        super(message, cause);
    }
}
