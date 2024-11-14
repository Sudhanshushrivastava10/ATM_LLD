package atm.Classes;

import atm.Exceptions.BalanceNotSuffcient;
import atm.Interfaces.Account;

public class SavingAccount implements Account {

    int accountNumber;
    double balance;

    public SavingAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    @Override
    public boolean withdrawal(double amount) throws BalanceNotSuffcient {
        if (amount > balance) {
            throw new BalanceNotSuffcient("Amount Not Sufficent");
        }

        balance -= amount;
        return true;
    }
}
