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
        var bank = bankReader.read();
        int option;
        do {
            System.out.println("1. Mostrar las cuentas del banco");
            System.out.println("2. Mostrar datos de una cuenta");
            System.out.println("3. Mostrar los datos de las cuentas de un cliente");
            System.out.println("4. Ingresar dinero en cuenta");
            System.out.println("5. Sacar dinero de una cuenta");
            System.out.println("6. Salir");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                
            }
            if (option == 2) {

            }
            if (option == 3) {

            }
            if (option == 4) {

            }
            if (option == 5) {

            }
            if (option == 6) {
                System.out.println("Saliendo...Adiós");
            }
            else {
                System.out.println("Opción inválida");
            }
        } while (option != 6);
    }
}
