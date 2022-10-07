import java.util.HashMap;
import java.util.Map;

public class BankMaintainer {

    private Map<String, Account> accountsList = new HashMap<>();

    public void addAccount(Account accountToAdd) {
        accountsList.put(accountToAdd.getAccountNumber(), accountToAdd);
    }

    public int getNumAccounts() {
        return accountsList.size();
    }

    public void closeAccount(String accountNumber) {
        accountsList.remove(accountNumber);
    }

    public void initiateDeposit(String accountNumber, int amountToDeposit) {
        accountsList.get(accountNumber).deposit(amountToDeposit);
    }

    public void initiateWithdrawal(String accountNumber, int amountToWithdrawal) {
        accountsList.get(accountNumber).withdrawal(amountToWithdrawal);
    }

    public void showAllAccounts(){
        //enhanced for loop , also called a for each loop
        //In English this reads... For each singular account object in the accountList collection
        for(Account account : accountsList.values()){
            System.out.println("Account Number: " + account.getAccountNumber() +
                    " Type: " + account.getType() + " Balance: " + account.getBalance());
        }
    }

    public Account findAccount(String accountNumber) {
        return accountsList.get(accountNumber);
    }
}
