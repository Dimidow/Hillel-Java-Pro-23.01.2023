package exceptions;

public class IncorrectFileNameException extends Exception{

        public IncorrectFileNameException(String message) {
        super(message);
    }

    public IncorrectFileNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
