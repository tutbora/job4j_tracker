package ru.job4j.warcraftlite;

import java.util.Random;

public class CreateArena {
    public CreateArena() {
    }

    public static int randomActions(int actions) {
        int rsl = 1;
        Random rand = new Random();
        if (actions == 1) {
            rsl = rand.nextInt(actions + 1) + 1;
        }
        if (actions == 2) {
            rsl = rand.nextInt(actions) + 3;
        }
        return rsl;
    }

    public static Actions account(int group) {
        int fromRandom = randomActions(group);
        Actions actions = new Actions();
        if (fromRandom == 1) {
            Unit unit = new Unit("Elf");
            actions.addUnit(unit);
            actions.addAccount(unit.getRace(), new Account("wizard", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("archer1", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("archer2", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("archer3", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("warrior1", 100, 1, 1, false));
            actions.addAccount(unit.getRace(), new Account("warrior2", 100, 1, 1, false));
            actions.addAccount(unit.getRace(), new Account("warrior3", 100, 1, 1, false));
            actions.addAccount(unit.getRace(), new Account("warrior4", 100, 1, 1, false));
        return actions;
        }
        if (fromRandom == 2) {
            Unit unit = new Unit("Human");
            actions.addUnit(unit);
            actions.addAccount(unit.getRace(), new Account("wizard", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("arbalester1", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("arbalester2", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("arbalester3", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("warrior1", 100, 1, 1, false));
            actions.addAccount(unit.getRace(), new Account("warrior2", 100, 1, 1, false));
            actions.addAccount(unit.getRace(), new Account("warrior3", 100, 1, 1, false));
            actions.addAccount(unit.getRace(), new Account("warrior4", 100, 1, 1, false));
            return actions;
        }
        if (fromRandom == 3) {
            Unit unit = new Unit("Orc");
            actions.addUnit(unit);
            actions.addAccount(unit.getRace(), new Account("shaman", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("archer1", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("archer2", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("archer3", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("goblin1", 100, 1, 1, false));
            actions.addAccount(unit.getRace(), new Account("goblin2", 100, 1, 1, false));
            actions.addAccount(unit.getRace(), new Account("goblin3", 100, 1, 1, false));
            actions.addAccount(unit.getRace(), new Account("goblin4", 100, 1, 1, false));
            return actions;
        }
        if (fromRandom == 4) {
            Unit unit = new Unit("Undead");
            actions.addUnit(unit);
            actions.addAccount(unit.getRace(), new Account("necromancer", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("hunter1", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("hunter2", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("hunter3", 100, 2, 1, false));
            actions.addAccount(unit.getRace(), new Account("zombie1", 100, 1, 1, false));
            actions.addAccount(unit.getRace(), new Account("zombie2", 100, 1, 1, false));
            actions.addAccount(unit.getRace(), new Account("zombie3", 100, 1, 1, false));
            actions.addAccount(unit.getRace(), new Account("zombie4", 100, 1, 1, false));
            return actions;
        }
        return actions;
    }

    public static void main(String[] args) {
        Unit unit = new Unit();
        var acc = CreateArena.account(1);
        System.out.println(acc);
        var acc2 = CreateArena.account(2);
        System.out.println(acc2);
    }
}
