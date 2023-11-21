package practice3;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
       super(message);
    }
}

// Custom exception for illegal bank transactions
class IllegalBankTransactionException extends Exception {
    public IllegalBankTransactionException(String message) {
       super(message);
    }
}

// SavingsAccount class
class SavingsAccount {
    private long id;
    private double balance;

    public SavingsAccount(long id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    // Method to withdraw money from the account
    public double withdraw(double amount) throws InsufficientBalanceException, IllegalBankTransactionException {
        if (amount < 0) {
            throw new IllegalBankTransactionException("Cannot withdraw a negative amount");
        }

        if (balance == 0 || amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        balance -= amount;
        return amount;
    }

    // Method to deposit money into the account
    public double deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        return balance;
    }

    // Getter method for balance
    public double getBalance() {
        return balance;
    }
}

public class SavingsAccountApplication {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(123456, 2000);

        try {
            // Attempt to withdraw a positive amount
            double withdrawnAmount = savingsAccount.withdraw(1500);
            System.out.println("Withdrawn amount: " + withdrawnAmount);
            System.out.println("Current balance: " + savingsAccount.getBalance());
        } catch (InsufficientBalanceException | IllegalBankTransactionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Attempt to withdraw more than the current balance
            double withdrawnAmount = savingsAccount.withdraw(2100);
            System.out.println("Withdrawn amount: " + withdrawnAmount);
        } catch (InsufficientBalanceException | IllegalBankTransactionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Attempt to withdraw a negative amount
            double withdrawnAmount = savingsAccount.withdraw(-1000);
            System.out.println("Withdrawn amount: " + withdrawnAmount);
        } catch (InsufficientBalanceException | IllegalBankTransactionException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

