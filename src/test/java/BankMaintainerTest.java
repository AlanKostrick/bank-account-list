import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankMaintainerTest {

    @Test
    public void shouldBeAbleToAdd2BankAccountsToTheDatabase() {
        //Arrange
        Account testChecking = new Account("1234", "Checking", 100);
        Account testSavings = new Account("5678", "Savings", 100);
        BankMaintainer underTest = new BankMaintainer();
        //Act
        underTest.addAccount(testChecking);
        underTest.addAccount(testSavings);
        int numAccounts = underTest.getNumAccounts();
        //Assert
        assertEquals(2, numAccounts);
    }

    @Test
    public void shouldBeAbleToCloseAnAccountInTheDatabase() {
        //Arrange
        Account testChecking = new Account("1234", "Checking", 100);
        Account testSavings = new Account("5678", "Savings", 100);
        BankMaintainer underTest = new BankMaintainer();
        //Act
        underTest.addAccount(testChecking);
        underTest.addAccount(testSavings);
        underTest.closeAccount("5678");
        int numAccounts = underTest.getNumAccounts();
        //Assert
        assertEquals(1, numAccounts);
    }

    @Test
    public void testCheckingShouldHaveABalanceOf150AfterADepositOf50() {
        //Arrange
        Account testChecking = new Account("1234", "Checking", 100);
        Account testSavings = new Account("5678", "Savings", 100);
        BankMaintainer underTest = new BankMaintainer();
        //Act
        underTest.addAccount(testChecking);
        underTest.addAccount(testSavings);
        underTest.initiateDeposit("1234", 50);
        //Assert
        assertEquals(150, testChecking.getBalance());
    }

    @Test
    public void testSavingsShouldHaveABalanceOf50afterAWithdrawalOf50() {
        Account testChecking = new Account("1234", "Checking", 100);
        Account testSavings = new Account("5678", "Savings", 100);
        BankMaintainer underTest = new BankMaintainer();
        //Act
        underTest.addAccount(testChecking);
        underTest.addAccount(testSavings);
        underTest.initiateWithdrawal("5678", 50);
        //Assert
        assertEquals(50, testSavings.getBalance());
    }

    @Test
    public void shouldFindTheAccountAndReturnTheBalance(){
        Account testChecking = new Account("1234", "Checking", 100);
        BankMaintainer underTest = new BankMaintainer();
        //Act
        underTest.addAccount(testChecking);
        Account accountToFind = underTest.findAccount("1234");
        //Assert
        assertEquals(100, accountToFind.getBalance());
    }

}
