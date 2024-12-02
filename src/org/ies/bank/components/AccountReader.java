package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class AccountReader {
    private final Scanner scanner;
    private final CustomerReader customerReader;

    public AccountReader(Scanner scanner, CustomerReader customerReader) {
        this.scanner = scanner;
        this.customerReader = customerReader;
    }

    public Account read() {
        System.out.println("Introuce los datos de la cuenta");
        System.out.println("IBAN:");
        String iban = scanner.nextLine();

        System.out.println("Saldo:");
        Double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Cliente:");
        Customer customer = customerReader.read();

        return new Account(
                iban,
                balance,
                customer
        );
    }
}
