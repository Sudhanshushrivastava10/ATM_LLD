import atm.Classes.ATMOperations;
import atm.Classes.AccountFactory;
import atm.Enums.AccountType;
import atm.Enums.TransactionType;
import atm.Exceptions.AccountTypeNotExist;
import atm.Exceptions.BalanceNotSuffcient;
import atm.Exceptions.NoAccountFound;
import atm.Interfaces.Account;

public class Main {

    public static void main(String[] args) throws AccountTypeNotExist, BalanceNotSuffcient, NoAccountFound {
        ATMOperations atmOperations = ATMOperations.getInstance();

        Account currentAccount = AccountFactory.createAccount(AccountType.Current, 1234, 300.0);
        Account savingAccount = AccountFactory.createAccount(AccountType.Saving, 1235, 100.0);

        atmOperations.addAccount(currentAccount);
        atmOperations.addAccount(savingAccount);

        atmOperations.performOperation(1234, TransactionType.Withdraw, 50);
        atmOperations.performOperation(1235, TransactionType.Deposit, 50);

        System.out.println(atmOperations.getBalance(1234));
        System.out.println(atmOperations.getBalance(1235));
    }
}