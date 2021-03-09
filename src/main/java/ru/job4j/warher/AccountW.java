package ru.job4j.warher;

import java.util.Objects;

public class AccountW {
    private int reqUnit;
    private double health;
    private double damage;
    private int priority;
    private boolean ill;
    private String unit;

    public AccountW(
            int reqUnit, double health, double damage, int priority, boolean ill, String unit) {
        this.reqUnit = reqUnit;
        this.health = health;
        this.damage = damage;
        this.priority = priority;
        this.ill = ill;
        this.unit = unit;
    }

    public int getReqUnit() {
        return reqUnit;
    }

    public void setReqUnit(int reqUnit) {
        this.reqUnit = reqUnit;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
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
        return Objects.equals(reqUnit, accountW.reqUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reqUnit);
    }
}