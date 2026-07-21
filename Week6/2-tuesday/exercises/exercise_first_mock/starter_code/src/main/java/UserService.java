import java.util.List;

/**
 * Business logic for managing users. This is the class under test.
 *
 * It depends on a {@link UserRepository} (persistence) and an
 * {@link EmailClient} (notifications). Both are supplied through the
 * constructor so that tests can inject Mockito mocks in their place.
 */
public class UserService {

    private final UserRepository repository;
    private final EmailClient emailClient;

    public UserService(UserRepository repository, EmailClient emailClient) {
        this.repository = repository;
        this.emailClient = emailClient;
    }

    /**
     * Look up a user by id.
     *
     * @throws UserNotFoundException if no user exists with that id
     */
    public User getUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + id));
    }

    /**
     * Create and persist a new user, then send them a welcome email.
     *
     * @throws IllegalArgumentException if the name or email is invalid
     * @throws DuplicateUserException   if a user with that email already exists
     */
    public User createUser(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
        if (repository.existsByEmail(email)) {
            throw new DuplicateUserException("Email already registered: " + email);
        }

        User saved = repository.save(new User(name, email));
        emailClient.send(email, "Welcome!", "Hello " + name + ", thanks for signing up.");
        return saved;
    }

    /**
     * @return all users currently marked active
     */
    public List<User> getActiveUsers() {
        return repository.findAllActive();
    }

    /**
     * @return the total number of users
     */
    public long getUserCount() {
        return repository.count();
    }

    /** Thrown when a requested user does not exist. */
    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    /** Thrown when creating a user whose email is already taken. */
    public static class DuplicateUserException extends RuntimeException {
        public DuplicateUserException(String message) {
            super(message);
        }
    }
}
