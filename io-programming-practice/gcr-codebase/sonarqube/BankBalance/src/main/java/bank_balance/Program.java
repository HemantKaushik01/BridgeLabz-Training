package bank_balance;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Program {
	 private static final Logger logger =
	            Logger.getLogger(Program.class.getName());
	int balance ;
	public Program(int balance) {
		this.balance=balance;
	}
	public int deposit(int amount) {
		if(amount<0) {
			throw new IllegalArgumentException("Deposit amount cannot be negative");
			
		}
		balance+=amount;
		
		logger.info("The Amount is successful deposit in account");
		logger.log(Level.INFO, "The current balance is: {0}", balance);


		return balance;
	}
	public int withdraw(int amount) {
		if(amount<0) {
			throw new IllegalArgumentException("Withdraw amount cannot be negative");
			
		}
		if(amount>balance) {
			throw new IllegalArgumentException("Insufficient funds");
			
		}
		balance-=amount;
		logger.info("The Amount is successful withdraw in account");
		logger.log(Level.INFO, "The current balance is: {0}", balance);

		return balance;
	}

	
}
