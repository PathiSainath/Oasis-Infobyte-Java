
import java.util.Scanner;

public class ATMInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    performTransaction();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("==== ATM Interface ====");
        System.out.println("1. Create Account");
        System.out.println("2. Perform Transaction");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createAccount() {
        System.out.print("Enter your name: ");
        String name = scanner.next();

        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        int accountNumber = bank.createAccount(name, balance);
        System.out.println("Account created successfully. Account number: " + accountNumber);
    }

    private static void performTransaction() {
        System.out.print("Enter your account number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter transaction type (1 - Deposit, 2 - Withdraw): ");
        int transactionType = scanner.nextInt();

        System.out.print("Enter transaction amount: ");
        double amount = scanner.nextDouble();

        boolean success;
        if (transactionType == 1) {
            success = bank.deposit(accountNumber, amount);
        } else if (transactionType == 2) {
            success = bank.withdraw(accountNumber, amount);
        } else {
            System.out.println("Invalid transaction type.");
            return;
        }

        if (success) {
            System.out.println("Transaction completed successfully.");
        } else {
            System.out.println("Transaction failed. Insufficient balance.");
        }
    }
}

class Bank {
    private static int nextAccountNumber = 1;
    private Account[] accounts;
    private int numAccounts;

    public Bank() {
        accounts = new Account[100];
        numAccounts = 0;
    }

    public int createAccount(String name, double balance) {
        Account account = new Account(nextAccountNumber++, name, balance);
        accounts[numAccounts++] = account;
        return account.getAccountNumber();
    }

    public boolean deposit(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null && account.getBalance() >= amount) {
            account.withdraw(amount);
            return true;
        }
        return false;
    }

    private Account getAccount(int accountNumber) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }
}

class Account {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

   
