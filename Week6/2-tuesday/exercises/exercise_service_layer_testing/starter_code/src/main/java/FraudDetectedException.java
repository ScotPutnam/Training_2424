/** Thrown when the fraud service rejects a transaction. */
public class FraudDetectedException extends RuntimeException {
    public FraudDetectedException(String message) {
        super(message);
    }
}
