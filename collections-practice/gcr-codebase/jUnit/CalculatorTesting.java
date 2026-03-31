package jUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTesting {
    Calculator calc = new Calculator();

    @Test
    void testAdd() { assertEquals(13, calc.add(5, 8)); }

    @Test
    void testSubtract() { assertEquals(2, calc.subtract(10, 8)); }

    @Test
    void testMultiply() { assertEquals(720, calc.multiply(8, 90)); }

    @Test
    void testDivide() { assertEquals(4, calc.divide(8, 2)); }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }
}
