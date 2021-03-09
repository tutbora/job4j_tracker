package ru.job4j.warher;

import java.util.Objects;

public class UserW {
    private String group;
    private String race;

    public UserW() {
    }

    public UserW(String group, String race) {
        this.group = group;
        this.race = race;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserW userW = (UserW) o;
        return Objects.equals(group, userW.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group);
    }
}