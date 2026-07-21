import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Starter test class. The mock wiring and helper methods below are provided;
 * the test methods (README Tasks 2-7) are yours to write.
 */
@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock private PaymentGateway paymentGateway;
    @Mock private OrderRepository orderRepository;
    @Mock private TransactionLogger transactionLogger;
    @Mock private FraudDetectionService fraudService;
    @Mock private RetryConfig retryConfig;

    @InjectMocks private PaymentService paymentService;

    private Order testOrder;
    private PaymentDetails testPaymentDetails;

    @BeforeEach
    void setUp() {
        testOrder = createTestOrder();
        testPaymentDetails = createTestPaymentDetails();
    }

    // TODO Task 2: happy-path tests
    // TODO Task 3: validation-error tests
    // TODO Task 4: fraud-detection tests
    // TODO Task 5: retry-logic tests
    // TODO Task 6: refund tests
    // TODO Task 7: interaction verification (ArgumentCaptor, InOrder)

    // ----- Helper methods (from the README) -----

    private Order createTestOrder() {
        Order order = new Order();
        order.setId(1L);
        order.setTotal(new BigDecimal("99.99"));
        order.setStatus(OrderStatus.PENDING);
        return order;
    }

    private PaymentDetails createTestPaymentDetails() {
        return new PaymentDetails("4111111111111111", "12/25", "123");
    }

    private PaymentResult createSuccessResult() {
        return new PaymentResult(true, "TXN123", null);
    }

    private PaymentResult createFailureResult(String reason) {
        return new PaymentResult(false, null, reason);
    }

    private FraudCheckResult createCleanResult() {
        return new FraudCheckResult(false, null);
    }

    private FraudCheckResult createFraudResult(String reason) {
        return new FraudCheckResult(true, reason);
    }
}
