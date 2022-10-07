public class Account {

    private String accountNumber;
    private String type;
    private int balance;
    public Account(String accountNumber, String type, int balance) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public void deposit(int amountToDeposit) {
        this.balance += amountToDeposit;
    }


    public void withdrawal(int amountToWithdrawal) {
        this.balance -= amountToWithdrawal;
    }


}
