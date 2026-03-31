package jUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTesting {
	TemperatureConverter tamp = new TemperatureConverter();

	@Test
	void testCtoF() {
		assertEquals(212, tamp.celsiusToFahrenheit(75));
	}

	@Test
	void testFtoC() {
		assertEquals(0, tamp.fahrenheitToCelsius(18));
	}
}
