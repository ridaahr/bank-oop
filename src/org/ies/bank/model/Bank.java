package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public void showAccounts() {
        for (var account: accounts) {
            account.showInfo();
        }
    }

    public void showAccount(String iban) {
        for (var account: accounts) {
            if (account.getIban().equals(iban)) {
                account.showInfo();
            }
        }
    }

    public void customerAccounts(String nif) {
        for (var account: accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                account.showInfo();
            }
        }
    }

    public void customerAccountsIban(String iban) {
        for (var account: accounts) {
            if (account.getIban().equals(iban)) {
                account.showInfo();
            }
        }
    }

    public Account findAccount(String iban) {
        for (var account: accounts) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }

    public Account findAccountN(String nif) {
        for (var account: accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                account.customerInfo();
            }
        }
        return null;
    }

    public void deposit(String iban, Double amount) {
        var account = findAccount(iban);

        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("No existe la cuenta");
        }
    }

    public void subBalance(String iban, Double amount) {
        var account = findAccount(iban);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
            } else {
                System.out.println("No hay suficiente dinero");
            }
        } else {
            System.out.println("No existe la cuenta");
        }
    }

    public int countCustomerAccounts(String nif) {
        int count = 0;
        for (var account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                count++;
            }
        }
        return count;
    }





//    public int numAccounts1(String nif) {
//        var quantity = 0;
//        for (var account: accounts) {
//            if (account.getCustomer().getNif().equals(nif)) {
//                quantity++;
//            }
//        } return quantity;
//    }

    public int numAccounts(String nif) {
        var quantity = 0;

        for (var account : accounts) {
            findAccountN(nif);
            if (account != null) {
                quantity++;
            } else {
                System.out.println("No existen cuentas asociadas a este nif");
            }
        }
        return quantity;
    }

    public Customer accountData(String iban) {
        var account = findAccount(iban);

        if (account != null) {
            return account.getCustomer();
        }
        return null;
    }

    public void checkAccounts(String ibanOrigin, String ibanDestination) {
        if (ibanOrigin == null && ibanDestination == null) {
            System.out.println("No existe ninguna de las cuentas");
        } else if (ibanOrigin == ibanDestination) {
            System.out.println("Has introducido cuentas iguales");
        } else if (ibanOrigin == null) {
            System.out.println("No existe la cuenta origen");
        } else if (ibanDestination == null) {
            System.out.println("No existe la cuenta destino");
        }
    }

    public void transferMoney(String ibanOrigin, String ibanDestination, double amount) {
        var account1 = findAccount(ibanOrigin);
        var account2 = findAccount(ibanDestination);

        checkAccounts(ibanOrigin, ibanDestination);

        if (account1 != null && account2 != null) {
            subBalance(ibanOrigin,amount);
            deposit(ibanDestination, amount);
        }
    }


    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }
}
