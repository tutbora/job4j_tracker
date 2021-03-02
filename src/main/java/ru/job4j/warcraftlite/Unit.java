package ru.job4j.warcraftlite;

public class Unit {
    private String position;
    private String unitName;

    public Unit(String position, String unitName) {
        this.position = position;
        this.unitName = unitName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
