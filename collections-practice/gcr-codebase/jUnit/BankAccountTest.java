package jUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
	BankAccount bank = new BankAccount();

	@Test
	void testDeposit() {
		bank.deposit(1000);
		assertEquals(100, bank.getBalance());
	}

	@Test
	void testWithdraw() {
		bank.deposit(10000);
		bank.withdraw(5400);
		assertEquals(500, bank.getBalance());
	}

	@Test
	void testWithdrawInsufficientFunds() {
		assertThrows(IllegalArgumentException.class, () -> bank.withdraw(50));
	}
}
