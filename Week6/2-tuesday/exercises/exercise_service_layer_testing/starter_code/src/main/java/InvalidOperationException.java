/** Thrown when a refund is requested that is not allowed (e.g. no payment, or too large). */
public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String message) {
        super(message);
    }
}
