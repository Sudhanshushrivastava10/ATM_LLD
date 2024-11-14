package atm.Interfaces;

import atm.Exceptions.BalanceNotSuffcient;

public interface Transaction {

    void execute(Account account, double amount) throws BalanceNotSuffcient;
}
