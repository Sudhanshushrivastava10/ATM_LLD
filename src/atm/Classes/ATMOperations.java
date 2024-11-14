package atm.Classes;

import java.util.HashMap;
import java.util.Map;

import atm.Enums.TransactionType;
import atm.Exceptions.BalanceNotSuffcient;
import atm.Exceptions.NoAccountFound;
import atm.Interfaces.Account;
import atm.Interfaces.Transaction;

public class ATMOperations {

    private static ATMOperations instance;
    Map<Integer, Account> map = new HashMap<>();

    private ATMOperations() {}

    public static ATMOperations getInstance() {
        if (instance == null) {
            instance = new ATMOperations();
        }

        return instance;
    }

    public void addAccount(Account account) {
        map.put(account.getAccountNumber(), account);
    }

    public void performOperation(int accountNumber, TransactionType type, double amount)
            throws NoAccountFound, BalanceNotSuffcient {
        Account account = getAccount(accountNumber);
        if (account == null) {
            throw new NoAccountFound("No such account found");
        }

        Transaction transaction = null;
        switch (type) {
            case Deposit -> {
                transaction = new AccountDeposit();
            }
            case Withdraw -> {
                transaction = new AccountWithdraw();
            }
            default -> System.out.println("Invalid Transaction");
        }

        transaction.execute(account, amount);
    }

    public Account getAccount(int accountNumber) {
        return map.get(accountNumber);
    }

    public double getBalance(int accountNumber) throws NoAccountFound {
        Account account = getAccount(accountNumber);
        if (account == null) {
            throw new NoAccountFound("No such account found");
        }

        return account.getBalance();
    }

}
