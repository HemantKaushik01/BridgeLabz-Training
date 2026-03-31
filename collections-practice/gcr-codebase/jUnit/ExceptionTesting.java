package jUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionTesting {
	@Test
	void testDivideByZero() {
		Exception ex = new Exception();
		assertThrows(ArithmeticException.class, () -> ex.divide(5, 0));
	}
}
