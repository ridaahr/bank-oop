package org.ies.bank;

import org.ies.bank.components.AccountReader;
import org.ies.bank.components.BankApp;
import org.ies.bank.components.BankReader;
import org.ies.bank.components.CustomerReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var customerReader = new CustomerReader(scanner);
        var accountReader = new AccountReader(scanner, customerReader);
        var bankReader = new BankReader(scanner, accountReader);
        var bankApp = new BankApp(scanner, bankReader);

        bankApp.run();
    }
}