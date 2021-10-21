package ru.job4j.warher;

public class CreateArenaW {
    public static final String GROUP1 = "1111";
    public static final String GROUP2 = "2222";
    public static final String RACE1 = "Elf";
    public static final String RACE2 = "Human";
    public static final String RACE3 = "Orc";
    public static final String RACE4 = "Undead";

    public CreateArenaW() {
    }

    public static BattleServiceW groups(int choice) {
        BattleServiceW battle = new BattleServiceW();
        int fromRandom = RandomW.randomRace(choice);
        int fromRandom2 = RandomW.randomRace(choice + 1);
        double health = 25D;
        UserW user;
        if (fromRandom == 1) {
            user = new UserW(GROUP1, RACE1);
            battle.addUser(user);
            battle.addAccount(user.getGroup(), new AccountW(0, health, 0D, 1, true, "wizard"));
            battle.addAccount(user.getGroup(), new AccountW(1, health, 7D, 1, true, "archer1"));
            battle.addAccount(user.getGroup(), new AccountW(2, health, 7D, 1, true, "archer2"));
            battle.addAccount(user.getGroup(), new AccountW(3, health, 7D, 1, true, "archer3"));
            battle.addAccount(user.getGroup(), new AccountW(4, health, 15D, 1, true, "warrior1"));
            battle.addAccount(user.getGroup(), new AccountW(5, health, 15D, 1, true, "warrior2"));
            battle.addAccount(user.getGroup(), new AccountW(6, health, 15D, 1, true, "warrior3"));
            battle.addAccount(user.getGroup(), new AccountW(7, health, 15D, 1, true, "warrior4"));
        }
        if (fromRandom == 2) {
            user = new UserW(GROUP1, RACE2);
            battle.addUser(user);
            battle.addAccount(user.getGroup(), new AccountW(0, health, 0D, 1, true, "wizard"));
            battle.addAccount(user.getGroup(), new AccountW(1, health, 5D, 1, true, "arbalester1"));
            battle.addAccount(user.getGroup(), new AccountW(2, health, 5D, 1, true, "arbalester2"));
            battle.addAccount(user.getGroup(), new AccountW(3, health, 5D, 1, true, "arbalester3"));
            battle.addAccount(user.getGroup(), new AccountW(4, health, 18D, 1, true, "warrior1"));
            battle.addAccount(user.getGroup(), new AccountW(5, health, 18D, 1, true, "warrior2"));
            battle.addAccount(user.getGroup(), new AccountW(6, health, 18D, 1, true, "warrior3"));
            battle.addAccount(user.getGroup(), new AccountW(7, health, 18D, 1, true, "warrior4"));
        }
        if (fromRandom2 == 3) {
            user = new UserW(GROUP2, RACE3);
            battle.addUser(user);
            battle.addAccount(user.getGroup(), new AccountW(0, health, 0D, 1, true, "shaman"));
            battle.addAccount(user.getGroup(), new AccountW(1, health, 3D, 1, true, "archer1"));
            battle.addAccount(user.getGroup(), new AccountW(2, health, 3D, 1, true, "archer2"));
            battle.addAccount(user.getGroup(), new AccountW(3, health, 3D, 1, true, "archer3"));
            battle.addAccount(user.getGroup(), new AccountW(4, health, 20D, 1, true, "goblin1"));
            battle.addAccount(user.getGroup(), new AccountW(5, health, 20D, 1, true, "goblin2"));
            battle.addAccount(user.getGroup(), new AccountW(6, health, 20D, 1, true, "goblin3"));
            battle.addAccount(user.getGroup(), new AccountW(7, health, 20D, 1, true, "goblin4"));
        }
        if (fromRandom2 == 4) {
            user = new UserW(GROUP2, RACE4);
            battle.addUser(user);
            battle.addAccount(user.getGroup(), new AccountW(0, health, 0D, 1, true, "necromancer"));
            battle.addAccount(user.getGroup(), new AccountW(1, health, 4D, 1, true, "hunter1"));
            battle.addAccount(user.getGroup(), new AccountW(2, health, 4D, 1, true, "hunter2"));
            battle.addAccount(user.getGroup(), new AccountW(3, health, 4D, 1, true, "hunter3"));
            battle.addAccount(user.getGroup(), new AccountW(4, health, 18D, 1, true, "zombie1"));
            battle.addAccount(user.getGroup(), new AccountW(5, health, 18D, 1, true, "zombie2"));
            battle.addAccount(user.getGroup(), new AccountW(6, health, 18D, 1, true, "zombie3"));
            battle.addAccount(user.getGroup(), new AccountW(7, health, 18D, 1, true, "zombie4"));
        }
        return battle;
    }
}
