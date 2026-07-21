/**
 * Outcome of a charge attempt. Provided starter code.
 *
 * Matches the helper method in the README:
 * {@code new PaymentResult(true, "TXN123", null)}.
 */
public class PaymentResult {

    private final boolean successful;
    private final String transactionId;
    private final String reason;

    public PaymentResult(boolean successful, String transactionId, String reason) {
        this.successful = successful;
        this.transactionId = transactionId;
        this.reason = reason;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getReason() {
        return reason;
    }
}
