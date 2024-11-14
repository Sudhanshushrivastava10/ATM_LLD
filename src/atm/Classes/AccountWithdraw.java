package atm.Classes;

import atm.Exceptions.BalanceNotSuffcient;
import atm.Interfaces.Account;
import atm.Interfaces.Transaction;

public class AccountWithdraw implements Transaction {

    @Override
    public void execute(Account account, double amount) throws BalanceNotSuffcient {
        if (account.withdrawal(amount)) {
            System.out.println("Rs. " + amount + " Withdrawn Successful");
        }
    }
}
