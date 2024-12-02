package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankReader {
    private final Scanner scanner;
    private final AccountReader accountReader;

    public BankReader(Scanner scanner, AccountReader accountReader) {
        this.scanner = scanner;
        this.accountReader = accountReader;
    }

    public Bank read() {
        System.out.println("Introduce los datos del banco");
        System.out.println("Nombre:");
        String name = scanner.nextLine();

        System.out.println("Número de cuentas");
        int size = scanner.nextInt();
        scanner.nextLine();
        Account[] accounts = new Account[size];
        for (int i = 0; i < size; i++) {
            accounts[i] = accountReader.read();
        }

        return new Bank(
                name,
                accounts
        );
    }
}
