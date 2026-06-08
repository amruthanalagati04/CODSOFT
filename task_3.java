import java.util.Scanner;

// Bank Account Class
class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully!");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn Successfully!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

// ATM Class
class ATM {
    BankAccount account;
    Scanner sc = new Scanner(System.in);

    ATM(BankAccount account) {
        this.account = account;
    }

    void showMenu() {
        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter Amount to Deposit: ₹");
                    double depositAmount = sc.nextDouble();

                    if (depositAmount > 0) {
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid Amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Amount to Withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();

                    if (withdrawAmount > 0) {
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid Amount!");
                    }
                    break;

                case 4:
                    System.out.println("Thank You for Using ATM!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);
    }
}

// Main Class
public class task_3 {
    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(5000);

        ATM atm = new ATM(userAccount);

        atm.showMenu();
    }
}