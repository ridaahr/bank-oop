package org.ies.bank.components;

public class BankApp2 {
    private final BankReader bankReader;

    public BankApp2(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        var bank = bankReader.read();

        var account = bank.findAccount("ES0001");
        if (account == null) {
            System.out.println("La cuenta no existe");
        } else {
            account.deposit(500);
        }

        var account2 = bank.findAccount("ES0002");
        if (account == null) {
            System.out.println("La cuenta no existe");
        } else {
            bank.subBalance("ES0002", 30.0);
        }

        account.showInfo();
        account2.showInfo();
        bank.transferMoney("ES0001", "ES0002", 500);
    }
}
