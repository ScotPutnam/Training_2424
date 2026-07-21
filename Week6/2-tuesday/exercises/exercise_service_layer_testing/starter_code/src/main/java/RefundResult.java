/**
 * Outcome of a refund attempt. Provided starter code.
 */
public class RefundResult {

    private final boolean successful;
    private final String transactionId;
    private final String reason;

    public RefundResult(boolean successful, String transactionId, String reason) {
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
