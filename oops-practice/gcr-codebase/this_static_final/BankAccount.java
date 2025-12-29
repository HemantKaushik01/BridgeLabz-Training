
import java.util.*;
public class BankAccount {
	String accountHolderName;
	final long accountNumber;
	  static int totalAccounts = 0;
	BankAccount(String accountHolderName,long accountNumber){
		this.accountHolderName=accountHolderName;
		this.accountNumber=accountNumber;
		 totalAccounts++;
		
	}
	public String name() {
		return accountHolderName;
	}
	
	static String bankName;

	
	public static void getTotalAccounts(BankAccount details){
		if (details instanceof BankAccount) {
            System.out.println("Account Holder Name: " + details.accountHolderName);
            System.out.println("Account Number: " + details.accountNumber);
            
        } else {
            System.out.println("Invalid BankAccount object.");
        }
		
	}
	 public static void getTotalAccountsCount() {
	        System.out.println("Total accounts created: " + totalAccounts);
	    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of Bank: ");
		bankName=sc.nextLine();
		System.out.print("Enter the number of accounts: ");
		int noBank = sc.nextInt();
		System.out.println();
		BankAccount bankAccounts[] =new BankAccount[noBank];
		for(int i=0;i<noBank;i++) {
			System.out.print("Enter the account Holder Name: ");
			String accountHolderName=sc.next();
			System.out.print("Enter the 12 digit account number: ");
			long accountNumber =sc.nextLong();
			bankAccounts[i]= new BankAccount(accountHolderName,accountNumber);
			
		}
		System.out.println("Bank name is : "+ bankName);
		for(BankAccount details : bankAccounts) {
		       getTotalAccounts(details);
		}
		 getTotalAccountsCount();

	}

}
