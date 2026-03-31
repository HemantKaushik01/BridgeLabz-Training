import java.time.LocalDateTime;
import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Transaction {
    private String type;
    private double amount;
    private String description;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount, String description, LocalDateTime timestamp) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return type + " = " + amount + " = " + description + " at " + timestamp;
    }
}

class Wallet {
    private String walletId;
    private double balance;
    private LinkedList<Transaction> history;

    public Wallet(String walletId) {
        this.walletId = walletId;
        this.balance = 0.0;
        this.history = new LinkedList<>();
    }

    public String getWalletId() {
        return walletId;
    }

    public double getBalance() {
        return balance;
    }

    public LinkedList<Transaction> getHistory() {
        return history;
    }

    public void addMoney(double amount) {
        balance += amount;
        history.add(new Transaction("ADD", amount, "Added money", LocalDateTime.now()));
    }

    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance in wallet " + walletId);
        }
        balance -= amount;
        history.add(new Transaction("WITHDRAW", amount, "Withdrew money", LocalDateTime.now()));
    }

    public void transfer(Wallet to, double amount, TransferService service) throws InsufficientBalanceException {
        service.transfer(this, to, amount);
        history.add(new Transaction("TRANSFER", amount, "Transferred to " + to.getWalletId(), LocalDateTime.now()));
        to.history.add(new Transaction("TRANSFER", amount, "Received from " + this.getWalletId(), LocalDateTime.now()));
    }
}

class User {
    private String userId;
    private String name;
    private String walletId;

    public User(String userId, String name, String walletId) {
        this.userId = userId;
        this.name = name;
        this.walletId = walletId;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getWalletId() {
        return walletId;
    }
}
interface TransferService {
   public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException;
}

class WalletTransfer implements TransferService {
    @Override
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException {
        from.withdrawMoney(amount);
        to.addMoney(amount);
    }
}

class BankTransfer implements TransferService {
    private double fee = 5.0;

    @Override
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException {
        from.withdrawMoney(amount + fee);
        to.addMoney(amount);
    }
}

public class DigitalWalletSystem {
    private HashMap<String, Wallet> wallets = new HashMap<>();
    private HashMap<String, User> users = new HashMap<>();

    public void createUser(String userId, String name) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId, name, userId + "_wallet"));
            createWallet(userId + "_wallet");
        }
    }

    public void createWallet(String walletId) {
        if (!wallets.containsKey(walletId)) {
            wallets.put(walletId, new Wallet(walletId));
        }
    }

    public Wallet getWallet(String walletId) {
        return wallets.get(walletId);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void addMoney(String walletId, double amount) {
        Wallet w = getWallet(walletId);
        if (w != null) {
            w.addMoney(amount);
        }
    }

    public void withdrawMoney(String walletId, double amount) throws InsufficientBalanceException {
        Wallet w = getWallet(walletId);
        if (w != null) {
            w.withdrawMoney(amount);
        }
    }

    public void transfer(String fromId, String toId, double amount, TransferService service) throws InsufficientBalanceException {
        Wallet from = getWallet(fromId);
        Wallet to = getWallet(toId);
        if (from != null && to != null) {
            from.transfer(to, amount, service);
        }
    }

    public LinkedList<Transaction> getTransactionHistory(String walletId) {
        Wallet w = getWallet(walletId);
        return w != null ? w.getHistory() : new LinkedList<>();
    }

    public static void main(String[] args) {
        DigitalWalletSystem obj = new DigitalWalletSystem();

        obj.createUser("user1", "Hemant");
        obj.createUser("user2", "Dhruv");



        obj.addMoney("user1_wallet", 1000.0);
        obj.addMoney("user2_wallet", 500.0);

        
        try {
            obj.transfer("user1_wallet", "user2_wallet", 200.0, new WalletTransfer());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        
        try {
            obj.transfer("user2_wallet", "user1_wallet", 100.0, new BankTransfer());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

    
        try {
            obj.withdrawMoney("user1_wallet", 50.0);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        
        System.out.println("Transaction history for user1:");
        for (Transaction t : obj.getTransactionHistory("user1_wallet")) {
            System.out.println(t);
        }

        
        System.out.println("Balance for user1: " + obj.getWallet("user1_wallet").getBalance());
        System.out.println("Balance for user2: " + obj.getWallet("user2_wallet").getBalance());
    }
}