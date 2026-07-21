/**
 * Outcome of a fraud screen. Provided starter code.
 *
 * Matches the README helpers:
 * {@code new FraudCheckResult(false, null)} (clean) and
 * {@code new FraudCheckResult(true, reason)} (flagged).
 */
public class FraudCheckResult {

    private final boolean rejected;
    private final String reason;

    public FraudCheckResult(boolean rejected, String reason) {
        this.rejected = rejected;
        this.reason = reason;
    }

    public boolean isRejected() {
        return rejected;
    }

    public String getReason() {
        return reason;
    }
}
