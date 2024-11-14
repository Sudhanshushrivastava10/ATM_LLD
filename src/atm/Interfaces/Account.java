package atm.Interfaces;

import atm.Exceptions.BalanceNotSuffcient;

public interface Account {

    int getAccountNumber();

    double getBalance();

    boolean deposit(double amount);

    boolean withdrawal(double amount) throws BalanceNotSuffcient;
}
