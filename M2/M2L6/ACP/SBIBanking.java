import java.util.Scanner;

// 1. User-defined Exception 1
class InvalidChoiceException extends Exception {
    public InvalidChoiceException(String msg) {
        super(msg);
    }
}

// 2. User-defined Exception 2
class LowBalanceException extends Exception {
    public LowBalanceException(String msg) {
        super(msg);
    }
}

// 3. User-defined Exception 3
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}

class BankAccount {
    private String accHolder;
    private int accNo;
    private double balance;
    private final double MIN_BALANCE = 1000.0; // SBI minimum balance rule
    
    BankAccount(String name, int accNo, double balance) throws LowBalanceException {
        this.accHolder = name;
        this.accNo = accNo;
        if(balance < MIN_BALANCE) {
            throw new LowBalanceException("Opening balance must be >= " + MIN_BALANCE);
        }
        this.balance = balance;
    }
    
    void deposit(double amount) {
        balance += amount;
        System.out.println("Rs " + amount + " deposited successfully");
    }
    
    void withdraw(double amount) throws InsufficientFundsException {
        if(balance - amount < MIN_BALANCE) {
            throw new InsufficientFundsException("Cannot withdraw. Minimum balance " + MIN_BALANCE + " must be maintained");
        }
        balance -= amount;
        System.out.println("Rs " + amount + " withdrawn successfully");
    }
    
    void checkBalance() {
        System.out.println("Current Balance: Rs " + balance);
    }
    
    void showDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accHolder);
        System.out.println("Account No: " + accNo);
        System.out.println("Balance: Rs " + balance);
    }
}

public class SBIBanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount acc = null;
        
        System.out.println("=== Welcome to State Bank of India ===");
        System.out.println("Est. 1806 as Bank of Calcutta");
        
        // Account creation with exception handling
        try {
            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Account No: ");
            int accNo = sc.nextInt();
            System.out.print("Enter Opening Balance: ");
            double bal = sc.nextDouble();
            
            acc = new BankAccount(name, accNo, bal); // may throw LowBalanceException
            System.out.println("Account Created Successfully!");
        } catch(LowBalanceException e) {
            System.out.println("Error: " + e.getMessage());
            sc.close();
            return;
        }
        
        int choice;
        do {
            System.out.println("\n=== SBI MENU ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            try {
                switch(choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double dAmt = sc.nextDouble();
                        acc.deposit(dAmt);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double wAmt = sc.nextDouble();
                        acc.withdraw(wAmt); // may throw InsufficientFundsException
                        break;
                    case 3:
                        acc.checkBalance();
                        break;
                    case 4:
                        acc.showDetails();
                        break;
                    case 5:
                        System.out.println("Thank you for banking with SBI!");
                        break;
                    default:
                        // throw user-defined exception
                        throw new InvalidChoiceException("Invalid choice! Please enter 1-5 only");
                }
            } 
            catch(InsufficientFundsException e) {
                System.out.println("Transaction Failed: " + e.getMessage());
            }
            catch(InvalidChoiceException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
        } while(choice != 5);
        
        sc.close();
    }
}