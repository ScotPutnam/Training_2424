import java.util.List;
import java.util.Optional;

/**
 * Data-access boundary for users.
 *
 * In a real application this would talk to a database. In your tests you will
 * replace it with a Mockito @Mock so no real database is needed.
 */
public interface UserRepository {

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);

    List<User> findAllActive();

    boolean existsByEmail(String email);

    long count();
}
