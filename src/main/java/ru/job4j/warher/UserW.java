package ru.job4j.warher;

import java.util.Objects;

public class UserW {
    private String passportGroup;
    private String usernameRace;

    public UserW() {
    }

    public UserW(String passportGroup, String usernameRace) {
        this.passportGroup = passportGroup;
        this.usernameRace = usernameRace;
    }

    public String getPassportGroup() {
        return passportGroup;
    }

    public void setPassportGroup(String passportGroup) {
        this.passportGroup = passportGroup;
    }

    public String getUsernameRace() {
        return usernameRace;
    }

    public void setUsernameRace(String usernameRace) {
        this.usernameRace = usernameRace;
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
        return Objects.equals(passportGroup, userW.passportGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportGroup);
    }
}