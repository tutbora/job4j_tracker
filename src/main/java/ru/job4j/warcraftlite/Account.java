package ru.job4j.warcraftlite;

import java.util.Objects;

public class Account {
        private String unitName;
        private int health;
        private int attack;
        private int prior;
        private boolean ill;

    public Account() {
    }

    public Account(String unitName, int health, int attack, int prior, boolean ill) {
        this.unitName = unitName;
        this.health = health;
        this.attack = attack;
        this.prior = prior;
        this.ill = ill;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(byte health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(byte attack) {
        this.attack = attack;
    }

    public int getPrior() {
        return prior;
    }

    public void setPrior(byte prior) {
        this.prior = prior;
    }

    public boolean isIll() {
        return ill;
    }

    public void setIll(boolean ill) {
        this.ill = ill;
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
        return Objects.equals(unitName, account.unitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitName);
    }
}
