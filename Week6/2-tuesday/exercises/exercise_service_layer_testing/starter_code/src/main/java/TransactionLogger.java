import java.math.BigDecimal;

/**
 * Records the outcome of payment and refund operations. Mocked in tests;
 * every method is void, so you will stub/verify these with the
 * {@code doNothing()} / {@code doThrow()} / {@code verify()} style.
 */
public interface TransactionLogger {

    void log(Long orderId, PaymentResult result);

    void logRejected(Long orderId, String reason);

    void logRefund(Long orderId, BigDecimal amount, String reason, RefundResult result);
}
