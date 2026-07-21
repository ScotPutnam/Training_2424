import java.math.BigDecimal;

/**
 * External payment provider. Mocked in tests.
 */
public interface PaymentGateway {

    /**
     * Charge a card.
     *
     * @throws PaymentTimeoutException if the gateway does not respond in time
     */
    PaymentResult charge(BigDecimal amount, PaymentDetails details);

    RefundResult refund(String transactionId, BigDecimal amount);
}
