/**
 * Lifecycle states an order can be in.
 */
public enum OrderStatus {
    PENDING,
    PAID,
    PAYMENT_FAILED,
    FRAUD_SUSPECTED,
    REFUNDED,
    PARTIALLY_REFUNDED,
    CANCELLED
}
