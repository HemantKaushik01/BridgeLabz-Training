import java.util.*;

class BankAccount {
    private int balance = 10000;

    synchronized boolean withdraw(String name, int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Transaction successful: " + name + ", Amount: " + amount + ", Balance: " + balance);
            return true;
        } else {
            System.out.println("Transaction failed: " + name + ", Insufficient balance");
            return false;
        }
    }
}

class Transaction implements Runnable {
    private BankAccount account;
    private String customer;
    private int amount;

    Transaction(BankAccount acc, String customer, int amount) {
        this.account = acc;
        this.customer = customer;
        this.amount = amount;
    }

    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] Attempting to withdraw " + amount);
        account.withdraw(customer, amount);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        int[] amounts = {3000,4000,2000,5000,1500};

        for (int i = 0; i < amounts.length; i++) {
            Thread t = new Thread(new Transaction(acc, "Customer-" + (i+1), amounts[i]));
            System.out.println(t.getName() + " state: " + t.getState());
            t.start();
        }
    }
}
