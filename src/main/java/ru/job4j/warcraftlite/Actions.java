package ru.job4j.warcraftlite;

import java.util.*;

public class Actions {
    private final Map<Unit, List<Account>> units = new HashMap<>();

    public void addUnit(Unit unit) {
        ArrayList<Account> accounts = new ArrayList<>();
        units.putIfAbsent(unit, accounts);
    }

    public static Actions addGroup(int group) {
        return CreateArena.account(group);
    }

    public Unit findByRace(String race) {
        for (var find : units.keySet()) {
            if (find.getRace().equals(race)) {
                return find;
            }
        }
        return null;
    }

    public Account findByUnitName(
            String race, String unitName) {
        Unit rsl = findByRace(race);
        if (rsl != null) {
            List<Account> accounts = units.get(rsl);
            for (var unitAccounts : accounts) {
                if (unitAccounts.getUnitName().contains(unitName)) {
                    return unitAccounts;
                }
            }
        }
        return null;
    }

    public void addAccount(String race, Account account) {
        Unit rsl = findByRace(race);
        if (rsl != null) {
            List<Account> list = units.get(rsl);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    public void fight() {
        Actions group1 = addGroup(1);
        Actions group2 = addGroup(2);
        Unit unit1 = findByRace("Elf");

    }

    public static void main(String[] args) {
        Actions group1 = addGroup(1);
        Actions group2 = addGroup(2);
    }
}
