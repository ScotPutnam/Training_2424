/** Thrown when payment fails after all retry attempts are exhausted. */
public class PaymentProcessingException extends RuntimeException {
    public PaymentProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
