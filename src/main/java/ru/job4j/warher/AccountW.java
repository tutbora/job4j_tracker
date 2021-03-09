package ru.job4j.warher;

import java.util.Objects;

public class AccountW {
    private String requisiteNUnit;
    private double balanceHealth;
    private double damage;
    private int priority;
    private boolean ill;
    private String unit;

    public AccountW(
            String requisiteNUnit, double balanceHealth, double damage, int priority, boolean ill, String unit) {
        this.requisiteNUnit = requisiteNUnit;
        this.balanceHealth = balanceHealth;
        this.damage = damage;
        this.priority = priority;
        this.ill = ill;
        this.unit = unit;
    }

    public String getRequisiteNUnit() {
        return requisiteNUnit;
    }

    public void setRequisiteNUnit(String requisiteNUnit) {
        this.requisiteNUnit = requisiteNUnit;
    }

    public double getBalanceHealth() {
        return balanceHealth;
    }

    public void setBalanceHealth(double balanceHealth) {
        this.balanceHealth = balanceHealth;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isIll() {
        return ill;
    }

    public void setIll(boolean ill) {
        this.ill = ill;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountW accountW = (AccountW) o;
        return Objects.equals(requisiteNUnit, accountW.requisiteNUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisiteNUnit);
    }
}