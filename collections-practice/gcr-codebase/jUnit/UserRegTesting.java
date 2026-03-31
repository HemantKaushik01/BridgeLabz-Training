package jUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegTesting {
    UserReg ur = new UserReg();

    @Test
    void testValidRegistration() {
        ur.registerUser("John", "john@example.com", "secret1");
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> ur.registerUser("", "john@example.com", "secret1"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> ur.registerUser("John", "invalidemail", "secret1"));
    }

    @Test
    void testShortPassword() {
        assertThrows(IllegalArgumentException.class, () -> ur.registerUser("John", "john@example.com", "123"));
    }
}
