import java.util.Scanner;

public class BankListApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String userChoice = "";

        Account myChecking = new Account("1234", "Checking", 500);
        Account mySavings = new Account("5678", "Savings", 500);

        BankMaintainer myBank = new BankMaintainer();

        myBank.addAccount(myChecking);
        myBank.addAccount(mySavings);

        System.out.println("Welcome to Codelaborators Banking ");
        System.out.println("Here are your accounts");
        myBank.showAllAccounts();

        System.out.println("Press 1 to see your account info");
        System.out.println("Press 2 to initiate a deposit");
        System.out.println("Press 3 to initiate a withdrawal");
        System.out.println("Press 4 to close an account");
        System.out.println("Press 5 to add an account");
        System.out.println("Press 6 to exit");
        userChoice = input.nextLine();

        while (!userChoice.equals("6")) {
            if (userChoice.equals("1")) {
                myBank.showAllAccounts();
            } else if(userChoice.equals("2")){
                System.out.println("What is your account number?");
                String acctNum = input.nextLine();
                System.out.println("How much would you like to deposit?");
                int amtToDeposit = input.nextInt();
                myBank.initiateDeposit(acctNum,amtToDeposit);
                input.nextLine();
            } else if(userChoice.equals("3")){
                System.out.println("What is your account number?");
                String acctNum = input.nextLine();
                System.out.println("How much would you like to withdrawal?");
                int amtToWithdrawal = input.nextInt();
                myBank.initiateWithdrawal(acctNum,amtToWithdrawal);
                input.nextLine();
            } else if(userChoice.equals("4")){
                //step 1: single out the account to close, and grab the remaining balance
                System.out.println("Enter the account number for the account to close");
                String acctNumToClose = input.nextLine();
                int remainingBalance = myBank.findAccount(acctNumToClose).getBalance();
                //step 2: single out the account to take on the deposit of that lingering balance
                System.out.println("Enter the account number to transfer the balance");
                String accountNumToDeposit = input.nextLine();
                myBank.initiateDeposit(accountNumToDeposit, remainingBalance);
                //step 3: close out the specific account desired
                myBank.closeAccount(acctNumToClose);
            } else if(userChoice.equals("5")){
                System.out.println("Key in the new account number");
                String acctNum = input.nextLine();
                System.out.println("What type of account is this? (Checking) or (Savings)");
                String acctType = input.nextLine();
                System.out.println("What is your initial balance?");
                int initialBalance = input.nextInt();
                Account accountToAdd = new Account(acctNum, acctType, initialBalance);
                myBank.addAccount(accountToAdd);
                input.nextLine();
            } else {
                System.out.println("Im sorry I did not recognize your request...please try again");
            }


            System.out.println("Press 1 to see your account info");
            System.out.println("Press 2 to initiate a deposit");
            System.out.println("Press 3 to initiate a withdrawal");
            System.out.println("Press 4 to close an account");
            System.out.println("Press 5 to add an account");
            System.out.println("Press 6 to exit");
            userChoice = input.nextLine();

        }

        System.out.println("Thanks for banking with us today.");

    }

}
