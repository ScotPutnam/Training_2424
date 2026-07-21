import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Starter test class. The mock wiring below is provided; the test methods
 * are yours to write (see README Tasks 2-5).
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @Mock
    private EmailClient emailClient;

    @InjectMocks
    private UserService userService;

    // TODO Task 2: getUser_existingUser_returnsUser()
    @Test
    @DisplayName("userService.getUser() re")
    void getUser_existingUser_returnsUser(){
        // arrange - arrange the mock
        User expectedUser = new User("john_smith","john_smith@email.com");
        expectedUser.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(expectedUser));

        // act - load expected user into user
        User actualUser = userService.getUser(1L);

        // assert
        assertEquals(expectedUser, actualUser);
        assertEquals("john_smith", actualUser.getName());
    }

    // TODO Task 3: getUser_nonExistentUser_throwsException()
    @Test
    @DisplayName("getUser() - userService with non-existent user; throws UserNotFoundException")
    void getUser_nonExistingUser_throwsException(){
        // arrange
        when(repository.findById(999L)).thenReturn(Optional.empty());

        // act & assert
        assertThrows(UserService.UserNotFoundException.class, () -> userService.getUser(999L));
    }

    // TODO Task 4: createUser success
    @Test
    void createUser_validUser_returnsUser(){

        // arrange


        // act

        // assert
        
    }

    // TODO Task 5: getActiveUsers() and getUserCount()
}
