package org.ies.bank.model;

import java.util.Objects;

public class Account {
    private String iban;
    private double balance;
    private Customer customer;

    public Account(String iban, Double balance, Customer customer) {
        this.iban = iban;
        this.balance = balance;
        this.customer = customer;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void customerInfo() {
        System.out.println("NIF: " + customer.getNif() + " Nombre: " + customer.getName() + " Apellidos: " + customer.getSurname());
    }

    public void showInfo() {
        System.out.println("IBAN: " + iban + ". Saldo " + balance + ".NIF Cliente " + customer.getNif());
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, balance, customer);
    }
}
