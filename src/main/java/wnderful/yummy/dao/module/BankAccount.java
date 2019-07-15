package wnderful.yummy.dao.module;

import javax.persistence.*;

@Entity
public class BankAccount {
    @Id
    private String accountId;

    @Column(nullable = false)
    private double balance;

    @Column(nullable = false)
    private String password;

    public BankAccount() {
    }

    public BankAccount(String accountId, double balance, String password) {
        this.accountId = accountId;
        this.balance = balance;
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
