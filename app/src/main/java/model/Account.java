package model;

import androidx.annotation.NonNull;

import java.util.PrimitiveIterator;

public class Account {
    private String password;
    private String email;
    private int accountId;

    public Account(String password, String email, int accountId) {
        this.password = password;
        this.email = email;
        this.accountId = accountId;
    }

    public Account() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(accountId);
    }
}
