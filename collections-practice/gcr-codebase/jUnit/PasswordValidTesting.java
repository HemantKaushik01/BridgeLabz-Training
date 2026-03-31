package jUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidTesting {
	PasswordValid pv = new PasswordValid();

	@Test
	void testValidPassword() {
		assertTrue(pv.isValid("Strong Password"));
	}

	@Test
	void testInvalidPassword() {
		assertFalse(pv.isValid("weakpassword"));
	}
}
