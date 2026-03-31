package bank_balance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bank_balance.Program;

public class UnitTest {
	Program obj;
    @BeforeEach
    void setUp() {
        obj = new Program(500000); // fresh object for each test
    }

	
	@Test
	public void testDepositValidAmount() {
		assertEquals(503000, obj.deposit(3000));
	}
	@Test
	public void testDepositNegativeAmount() {

		
		assertThrows(IllegalArgumentException.class, () -> obj.deposit(-200000));
		
	}
	@Test
	public void testWithdrawValidAmount() {


		assertEquals(300000, obj.withdraw(200000));

	}
	@Test
	public void testWithdrawInsufficientFunds() {
	

        assertThrows(IllegalArgumentException.class, () -> obj.withdraw(800000));

		
	}
}
