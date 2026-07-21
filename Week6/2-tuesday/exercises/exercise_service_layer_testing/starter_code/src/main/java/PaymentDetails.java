/**
 * Card details supplied for a payment. Provided starter code.
 */
public class PaymentDetails {

    private final String cardNumber;
    private final String expiry;
    private final String cvv;

    public PaymentDetails(String cardNumber, String expiry, String cvv) {
        this.cardNumber = cardNumber;
        this.expiry = expiry;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getCvv() {
        return cvv;
    }
}
