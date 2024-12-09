package org.ies.bank.components;

import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();
        int option;
        do {
            option = chooseOption();
            if (option == 1) {
                bank.showAccounts();
            }
            else if (option == 2) {
                System.out.println("Introduce el iban: ");
                var iban = scanner.nextLine();
                bank.showAccount(iban);
            }
            else if (option == 3) {
                System.out.println("Introduce el nif: ");
                var nif = scanner.nextLine();
                bank.customerAccounts(nif);
            }
            else if (option == 4) {
                System.out.println("Introduce el iban: ");
                var iban = scanner.nextLine();
                System.out.println("Introduce la cantidad: ");
                var amount = scanner.nextDouble();
                scanner.nextLine();
                bank.deposit(iban, amount);
                bank.showAccount(iban);
            }
            else if (option == 5) {
                System.out.println("Introduce el iban: ");
                var iban = scanner.nextLine();
                System.out.println("Introduce la cantidad: ");
                var amount = scanner.nextDouble();
                scanner.nextLine();
                bank.subBalance(iban, amount);
                bank.showAccount(iban);
            }
            else if (option == 6) {
                System.out.println("Introduce el NIF del cliente:");
                String nif = scanner.nextLine();

                int customerAccountsNumber = bank.countCustomerAccounts(nif);
                System.out.println("El cliente tiene " + customerAccountsNumber + " cuentas.");
            } else if (option == 7) {
                System.out.println("Introduce el IBAN:");
                String iban = scanner.nextLine();

                bank.customerAccounts(iban);
            } else if (option == 8) {
                System.out.println("Introduce el IBAN de origen");
                var ibanOrigin = scanner.nextLine();
                System.out.println("Introduce el IBAN de destino");
                var ibanDestination = scanner.nextLine();
                System.out.println("Introduce la cantidad a transferir");
                var amount = scanner.nextDouble();
                scanner.nextLine();

                bank.transferMoney(ibanOrigin, ibanDestination, amount);
                bank.showAccount(ibanOrigin);
                bank.showAccount(ibanDestination);
            } else if (option == 8) {
                System.out.println("Saliendo...Adiós");
            }

            else {
                System.out.println("Opción inválida");
            }
        } while (option != 9);
    }

    private int chooseOption() {
        int option;
        do {
            System.out.println("Elige una opcion:");
            System.out.println("1. Mostrar cuentas");
            System.out.println("2. Mostrar datos cuenta");
            System.out.println("3. Mostrar cuentas de cliente");
            System.out.println("4. Ingresar");
            System.out.println("5. Sacar");
            System.out.println("6. Contar cuentas de cliente");
            System.out.println("7. Mostrar titular de cuenta");
            System.out.println("8. Hacer una transferencia");
            System.out.println("9. Salir");
            option = scanner.nextInt();
            scanner.nextLine();
        } while (option < 1 || option > 9);
        return option;
    }
}
