/**
 * Tunable retry settings for payment processing. Mocked in tests so you can
 * control the attempt count and use a zero delay.
 */
public class RetryConfig {

    private final int maxAttempts;
    private final long retryDelayMs;

    public RetryConfig(int maxAttempts, long retryDelayMs) {
        this.maxAttempts = maxAttempts;
        this.retryDelayMs = retryDelayMs;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public long getRetryDelayMs() {
        return retryDelayMs;
    }
}
