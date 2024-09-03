/*TASK 3 ATM INTERFACE 
1.Create a class to represent the ATM machine.
2. Design the user interface for the ATM, including options such as withdrawing, depositing, and checking the balance.
3. Implement methods for each option, such as withdraw(amount), deposit(amount), and checkBalance().
4. Create a class to represent the user's bank account, which stores the account balance.
5. Connect the ATM class with the user's bank account class to access and modify the account balance.
6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions.
*/

import java.util.Scanner; //to perform input operations

//BankAccount class to represent individual user's bank account

class BankAccount {
    // variable to check bank balance access specifier is private so that we cannot access this variable directly 
    private double balance;

    // constructor to intialize the instance variable "balance" ..At the time of creating object of class BankAccount we have to pass a starting deposited amount by user
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money in account but first it checks that amount is positive or not
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully Deposited Money: Rs" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money ..conditions to check 1)number is positive 2)number is less than or equal to balance 
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: Rs " + amount);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current balance: Rs " + balance);
    }

    // this method return the balance remain in account and making it public allowed other classes to access it  
    public double getBalance() {
        return balance;
    }
}

// Class to represent the ATM machine
public class ATM {

    private BankAccount bankAccount;
    private Scanner scanner;

    // initalize the bankAccount and scanner object 
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu and handle user input Menu driven 
    public void showMenu() {
        while (true) {
            // prompt for user to enter his option
            System.out.println("\nATM Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            // variable to store input from user 
            int option = scanner.nextInt();

            // switch case to handle the option provided by user
            switch (option) {
                case 1:
                    handleDeposit();
                    break;
                case 2:
                    handleWithdraw();
                    break;
                case 3:
                    bankAccount.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return; // Exit the program 
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Handle deposit transactions 
    private void handleDeposit() {
        System.out.print("Enter amount to deposit: RS");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    // Handle withdraw transactions
    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: RS");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }

    public static void main(String[] args) {

        // Initialize the user's bank account with a starting balance of RS 100
        BankAccount account = new BankAccount(100);
        ATM atm = new ATM(account);

        // Show the ATM menu 
        atm.showMenu();
    }
}


/*Menu
 ATM Menu:
1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Select an option:
 */

 /*Deposite money
ATM Menu:
1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Select an option: 1
Enter amount to deposit: RS200
Successfully Deposited Money: Rs200.0
  */

/*
 withdraw:
 ATM Menu:
1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Select an option: 2
Enter amount to withdraw: RS100
Withdrew: Rs 100.0
 */

/*withdrawing more money that actually store in account
 ATM Menu:
1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Select an option: 2
Enter amount to withdraw: RS100000
Insufficient funds.
 */

/*check balance
 ATM Menu:
1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Select an option: 3
Current balance: Rs 100.0
 */

/*Exit
ATM Menu:
1. Deposit
2. Withdraw
3. Check Balance
4. Exit
Select an option: 4
Exiting...

 */