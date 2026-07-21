import java.math.BigDecimal;

/**
 * Screens transactions for fraud. Mocked in tests.
 */
public interface FraudDetectionService {

    FraudCheckResult checkTransaction(String cardNumber, BigDecimal amount);
}
