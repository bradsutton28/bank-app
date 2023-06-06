import java.util.Scanner;
// Simple program for bank app simulator no GUI
public class bankingApp {

    public static void main(String[] args) {
        bankAccount customer = new bankAccount("Bradley Sutton", "69");
        customer.showUserMenu();

    }

}

class bankAccount {

    // Simple variables expected for a bank account
    int accBalance;
    int lastTransaction;
    String userName;
    String userID;

    bankAccount(String name, String ID){
        userName = name;
        userID = ID;
    }

    // Deposits money for the user and saves the amount as the last transaction
    void deposit(int amount){
        if(amount != 0){
            accBalance = accBalance + amount;
            lastTransaction = amount;
        }
    }

    // Simple withdraw function
    void withdraw(int amount){
        if(amount != 0){
            accBalance = accBalance - amount;
            lastTransaction = -amount;
        }
    }

    // Function to get the last transaction on the account
    void getLastTransaction(){
        if(lastTransaction < 0){
            System.out.println("You withdrew: " + Math.abs(lastTransaction)+".");
        }else if(lastTransaction > 0){
            System.out.println("You deposited: "+ lastTransaction+".");
        }else{
            System.out.println("No transactions on record for this account.");

        }
    }
    // the beef of the program do while to get choice from user and continue through until they want to quit
    void showUserMenu() {
        char choice = 'k';
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome: " + userName);
        System.out.println("UserID: " + userID + "\n");
        System.out.println("1. Check current account balance");
        System.out.println("2. Deposit money into your account");
        System.out.println("3. Withdraw money from your account");
        System.out.println("4. View your previous transaction");
        System.out.println("q. To Exit the program");

        do {
            System.out.println("-------------------------------");
            System.out.println("Enter your choice exactly as shown");
            System.out.println("-------------------------------");
            choice = scan.next().charAt(0);
            System.out.println("\n");

            switch (choice) {
                case ('1'):
                    System.out.println("-------------------------------");
                    System.out.println("Your account balance is $" + accBalance + ".");
                    System.out.println("-------------------------------");
                    System.out.println("\n");
                    break;

                case ('2'):
                    System.out.println("-------------------------------");
                    System.out.println("Please enter the amount you would like to deposit today.");
                    System.out.println("-------------------------------");
                    int amount = scan.nextInt();
                    deposit(amount);
                    System.out.println("Your new balance is $" + accBalance + ".");
                    System.out.println("\n");
                    break;

                case ('3'):
                    System.out.println("-------------------------------");
                    System.out.println("Please enter the amount you would like to withdraw today.");
                    System.out.println("-------------------------------");
                    int amount2 = scan.nextInt();
                    withdraw(amount2);
                    System.out.println("Your new balance is $" + accBalance + ".");
                    System.out.println("\n");
                    break;

                case ('4'):
                    System.out.println("-------------------------------");
                    getLastTransaction();
                    System.out.println("-------------------------------");
                    System.out.println("\n");
                    break;

                case('q'):
                    System.out.println("-------------------------------");
                    break;

                default:
                    System.out.println("This is an invalid option, please enter the option exactly as you see it.");
                    break;

            }

        } while(choice != 'q');
        System.out.println("Thank you, come again");
   }
}

