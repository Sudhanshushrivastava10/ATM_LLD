package atm.Classes;

import atm.Enums.AccountType;
import atm.Exceptions.AccountTypeNotExist;
import atm.Interfaces.Account;

public class AccountFactory {

    public static Account createAccount(AccountType type, int accountNumber, double initialAmount) throws
            AccountTypeNotExist {
        switch (type) {
            case Saving -> {
                return new SavingAccount(accountNumber, initialAmount);
            }
            case Current -> {
                return new CurrentAccount(accountNumber, initialAmount);
            }
            default -> throw new AccountTypeNotExist("No Such Account Type Exist");
        }

    }
}
