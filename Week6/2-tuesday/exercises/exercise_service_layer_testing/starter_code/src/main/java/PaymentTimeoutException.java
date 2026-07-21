/**
 * Thrown by the payment gateway when it does not respond in time. The service
 * catches this and retries.
 */
public class PaymentTimeoutException extends RuntimeException {
    public PaymentTimeoutException(String message) {
        super(message);
    }
}
