package org.ies.bank.components;

import org.ies.bank.model.Account;

public class BankApp3 {
    private final BankReader bankReader;

    public BankApp3(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        var bank = bankReader.read();

        bank.showAccounts();
        bank.subBalance("ES0003", 50.0);
        bank.findAccountN("000X");
        bank.deposit("ES0004", 300.0);
        bank.customerAccountsIban("ES0001");
    }
}
