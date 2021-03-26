package ru.job4j.bank;

import java.util.Objects;

/**
 * @author Z.Ruslan
 * @version 1.0
 * Class frame work with fields
 */
public class Account {

    /**
     * it is requisite for account number for stocks different currencies
     */
    private String requisite;

    /**
     * it size of currency on account requisite
     */
    private double balance;

    /**
     * it is account which contains data about requisite and balance
     * @param requisite it is account number
     * @param balance it is how much money are stock in account requisite
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Method lets get requisite account
     * @return if by ask gives back requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * @deprecated this method is not using yet,
     * but it can set (create or change) requisite for account number
     * @param requisite initialisation parameter of requisite
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Method gives back money size which on balance account
     * @return if by ask gives balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * it sets (or change) balance for account requisite
     * @param balance initialisation parameter of balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}