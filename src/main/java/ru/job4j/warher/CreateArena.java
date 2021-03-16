package ru.job4j.warher;

public class CreateArena {
    public static final String GROUP1 = "1111";
    public static final String GROUP2 = "2222";
    public static final String RACE1 = "Elf";
    public static final String RACE2 = "Human";
    public static final String RACE3 = "Orc";
    public static final String RACE4 = "Undead";

    public CreateArena() {
    }

    public static BattleServiceW groups(int choice) {
        BattleServiceW bank = new BattleServiceW();
        int fromRandom = RandomW.randomRace(choice);
        int fromRandom2 = RandomW.randomRace(choice + 1);
        double health = 25D;
        UserW user;
        if (fromRandom == 1) {
            user = new UserW(GROUP1, RACE1);
            bank.addUser(user);
            bank.addAccount(user.getGroup(), new AccountW(0, health, 0D, 1, true, "wizard"));
            bank.addAccount(user.getGroup(), new AccountW(1, health, 7D, 1, true, "archer1"));
            bank.addAccount(user.getGroup(), new AccountW(2, health, 7D, 1, true, "archer2"));
            bank.addAccount(user.getGroup(), new AccountW(3, health, 7D, 1, true, "archer3"));
            bank.addAccount(user.getGroup(), new AccountW(4, health, 15D, 1, true, "warrior1"));
            bank.addAccount(user.getGroup(), new AccountW(5, health, 15D, 1, true, "warrior2"));
            bank.addAccount(user.getGroup(), new AccountW(6, health, 15D, 1, true, "warrior3"));
            bank.addAccount(user.getGroup(), new AccountW(7, health, 15D, 1, true, "warrior4"));
        }
        if (fromRandom == 2) {
            user = new UserW(GROUP1, RACE2);
            bank.addUser(user);
            bank.addAccount(user.getGroup(), new AccountW(0, health, 0D, 1, true, "wizard"));
            bank.addAccount(user.getGroup(), new AccountW(1, health, 5D, 1, true, "arbalester1"));
            bank.addAccount(user.getGroup(), new AccountW(2, health, 5D, 1, true, "arbalester2"));
            bank.addAccount(user.getGroup(), new AccountW(3, health, 5D, 1, true, "arbalester3"));
            bank.addAccount(user.getGroup(), new AccountW(4, health, 18D, 1, true, "warrior1"));
            bank.addAccount(user.getGroup(), new AccountW(5, health, 18D, 1, true, "warrior2"));
            bank.addAccount(user.getGroup(), new AccountW(6, health, 18D, 1, true, "warrior3"));
            bank.addAccount(user.getGroup(), new AccountW(7, health, 18D, 1, true, "warrior4"));
        }
        if (fromRandom2 == 3) {
            user = new UserW(GROUP2, RACE3);
            bank.addUser(user);
            bank.addAccount(user.getGroup(), new AccountW(0, health, 0D, 1, true, "shaman"));
            bank.addAccount(user.getGroup(), new AccountW(1, health, 3D, 1, true, "archer1"));
            bank.addAccount(user.getGroup(), new AccountW(2, health, 3D, 1, true, "archer2"));
            bank.addAccount(user.getGroup(), new AccountW(3, health, 3D, 1, true, "archer3"));
            bank.addAccount(user.getGroup(), new AccountW(4, health, 20D, 1, true, "goblin1"));
            bank.addAccount(user.getGroup(), new AccountW(5, health, 20D, 1, true, "goblin2"));
            bank.addAccount(user.getGroup(), new AccountW(6, health, 20D, 1, true, "goblin3"));
            bank.addAccount(user.getGroup(), new AccountW(7, health, 20D, 1, true, "goblin4"));
        }
        if (fromRandom2 == 4) {
            user = new UserW(GROUP2, RACE4);
            bank.addUser(user);
            bank.addAccount(user.getGroup(), new AccountW(0, health, 0D, 1, true, "necromancer"));
            bank.addAccount(user.getGroup(), new AccountW(1, health, 4D, 1, true, "hunter1"));
            bank.addAccount(user.getGroup(), new AccountW(2, health, 4D, 1, true, "hunter2"));
            bank.addAccount(user.getGroup(), new AccountW(3, health, 4D, 1, true, "hunter3"));
            bank.addAccount(user.getGroup(), new AccountW(4, health, 18D, 1, true, "zombie1"));
            bank.addAccount(user.getGroup(), new AccountW(5, health, 18D, 1, true, "zombie2"));
            bank.addAccount(user.getGroup(), new AccountW(6, health, 18D, 1, true, "zombie3"));
            bank.addAccount(user.getGroup(), new AccountW(7, health, 18D, 1, true, "zombie4"));
        }
        return bank;
    }
}
