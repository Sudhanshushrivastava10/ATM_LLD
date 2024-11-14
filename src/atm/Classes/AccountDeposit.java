package atm.Classes;

import atm.Interfaces.Account;
import atm.Interfaces.Transaction;

public class AccountDeposit implements Transaction {

    @Override
    public void execute(Account account, double amount) {
        if (account.deposit(amount)) {
            System.out.println("Rs. " + amount + " Amount Deposited");
        }
    }
}
