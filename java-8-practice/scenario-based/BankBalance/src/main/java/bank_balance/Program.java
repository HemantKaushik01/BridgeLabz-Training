package bank_balance;

public class Program {
	int balance ;
	public Program(int balance) {
		this.balance=balance;
	}
	public int deposit(int amount) {
		if(amount<0) {
			throw new IllegalArgumentException("Deposit amount cannot be negative");
			
		}
		balance+=amount;
		
		System.out.println("The Amount is successful deposit in account");
		System.out.println("The current balance is: "+balance);
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
		System.out.println("The Amount is successful withdraw in account");
		System.out.println("The current balance is: "+balance);
		return balance;
	}

}
