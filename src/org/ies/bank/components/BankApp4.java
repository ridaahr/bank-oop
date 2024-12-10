package org.ies.bank.components;

public class BankApp4 {
    private final BankReader bankReader;

    public BankApp4(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        var bank = bankReader.read();
        var account1 = bank.findAccount("ES0001");

        if (account1 == null) {
            System.out.println("No existe la cuenta");
        } else {
            bank.showAccount("ES0001");
            bank.transferMoney("ES0001", "ES0002", account1.getBalance());
            System.out.println(bank);
        }
    }
}
