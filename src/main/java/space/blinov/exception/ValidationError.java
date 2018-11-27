package space.blinov.exception;

public class ValidationError extends RuntimeException {
    public ValidationError(String message) {
        super(message);
    }
}
