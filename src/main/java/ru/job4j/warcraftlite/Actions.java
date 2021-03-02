package ru.job4j.warcraftlite;

import java.util.*;

public class Actions {
    private final Map<Unit, List<Account>> units = new HashMap<>();

    private static int randomActions(int actions) {
        int rsl = 0;
        Random rand = new Random();
        if (actions == 2) {
            rsl = rand.nextInt(actions);
        }
        if (actions == 3) {
            rsl = rand.nextInt(actions);
        }
        return rsl + 1;
    }

    public void addUnit(Unit unit) {
        ArrayList<Account> list = new ArrayList<>();
        units.putIfAbsent(unit, list);
    }

    public Unit findByPosition(String position) {
        for (var find : units.keySet()) {
            if (find.getPosition().equals(position)) {
                return find;
            }
        }
        return null;
    }
}
