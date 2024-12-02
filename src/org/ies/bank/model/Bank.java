package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;
import org.ies.bank.model.Account;

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

    public void addBalance(String iban, Double quantity) {
        for (var account: accounts) {
            if (account.getIban().equals(iban)) {
                account.setBalance(account.getBalance() + quantity);
            } else {
                System.out.println("No existe la cuenta");
            }
        }
    }

    public void subBalance(String iban, Double quantity) {
        for (var account: accounts) {
            if (account.getIban().equals(iban)) {
                if (account.getBalance() >= quantity) {
                    account.setBalance(account.getBalance() - quantity);
                } else {
                    System.out.println("No hay suficiente dinero");
                }
            } else {
                System.out.println("No existe la cuenta");
            }
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
