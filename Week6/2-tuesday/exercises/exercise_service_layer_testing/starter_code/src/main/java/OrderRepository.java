import java.util.Optional;

/**
 * Persistence boundary for orders. Mocked in tests.
 */
public interface OrderRepository {

    Optional<Order> findById(Long id);

    Order save(Order order);
}
