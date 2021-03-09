package ru.job4j.warher;

import java.util.LinkedHashSet;
import java.util.Random;

public class CreateArena {
    public CreateArena() {
    }

    public static int randomNumber(int actions) {
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

    public static int[] randomGroup(int actions) {
        LinkedHashSet<Integer> test = new LinkedHashSet<Integer>();
        Random random = new Random();
        int[] rsl = new int[actions];
        int ii = 0;
        do {
            test.add(random.nextInt(actions) + 1);
        }
        while (test.size() != actions);
        for (var i : test) {
            rsl[ii] = (int) i;
            ii++;
        }
        return rsl;
    }

    public static BankServiceW groups(int choice) {
        int fromRandom = randomNumber(choice);
        int fromRandom2 = randomNumber(choice + 1);
        BankServiceW bank = new BankServiceW();
        UserW user;
        if (fromRandom == 1) {
            user = new UserW("1111", "Elf");
            bank.addUser(user);
            bank.addAccount(user.getGroup(), new AccountW(1, 100, 0, 1, true, "wizard"));
            bank.addAccount(user.getGroup(), new AccountW(2, 100, 7, 1, true, "archer1"));
            bank.addAccount(user.getGroup(), new AccountW(3, 100, 7, 1, true, "archer2"));
            bank.addAccount(user.getGroup(), new AccountW(4, 100, 7, 1, true, "archer3"));
            bank.addAccount(user.getGroup(), new AccountW(5, 100, 15, 1, true, "warrior1"));
            bank.addAccount(user.getGroup(), new AccountW(6, 100, 15, 1, true, "warrior2"));
            bank.addAccount(user.getGroup(), new AccountW(7, 100, 15, 1, true, "warrior3"));
            bank.addAccount(user.getGroup(), new AccountW(8, 100, 15, 1, true, "warrior4"));
        }
        if (fromRandom == 2) {
            user = new UserW("1111", "Human");
            bank.addUser(user);
            bank.addAccount(user.getGroup(), new AccountW(1, 100, 0, 1, true, "wizard"));
            bank.addAccount(user.getGroup(), new AccountW(2, 100, 5, 1, true, "arbalester1"));
            bank.addAccount(user.getGroup(), new AccountW(3, 100, 5, 1, true, "arbalester2"));
            bank.addAccount(user.getGroup(), new AccountW(4, 100, 5, 1, true, "arbalester3"));
            bank.addAccount(user.getGroup(), new AccountW(5, 100, 18, 1, true, "warrior1"));
            bank.addAccount(user.getGroup(), new AccountW(6, 100, 18, 1, true, "warrior2"));
            bank.addAccount(user.getGroup(), new AccountW(7, 100, 18, 1, true, "warrior3"));
            bank.addAccount(user.getGroup(), new AccountW(8, 100, 18, 1, true, "warrior4"));
        }
        if (fromRandom2 == 3) {
            user = new UserW("2222", "Orc");
            bank.addUser(user);
            bank.addAccount(user.getGroup(), new AccountW(1, 100, 0, 1, true, "shaman"));
            bank.addAccount(user.getGroup(), new AccountW(2, 100, 3, 1, true, "archer1"));
            bank.addAccount(user.getGroup(), new AccountW(3, 100, 3, 1, true, "archer2"));
            bank.addAccount(user.getGroup(), new AccountW(4, 100, 3, 1, true, "archer3"));
            bank.addAccount(user.getGroup(), new AccountW(5, 100, 20, 1, true, "goblin1"));
            bank.addAccount(user.getGroup(), new AccountW(6, 100, 20, 1, true, "goblin2"));
            bank.addAccount(user.getGroup(), new AccountW(7, 100, 20, 1, true, "goblin3"));
            bank.addAccount(user.getGroup(), new AccountW(8, 100, 20, 1, true, "goblin4"));
        }
        if (fromRandom2 == 4) {
            user = new UserW("2222", "Undead");
            bank.addUser(user);
            bank.addAccount(user.getGroup(), new AccountW(1, 100, 0, 1, true, "necromancer"));
            bank.addAccount(user.getGroup(), new AccountW(2, 100, 4, 1, true, "hunter1"));
            bank.addAccount(user.getGroup(), new AccountW(3, 100, 4, 1, true, "hunter2"));
            bank.addAccount(user.getGroup(), new AccountW(4, 100, 4, 1, true, "hunter3"));
            bank.addAccount(user.getGroup(), new AccountW(5, 100, 18, 1, true, "zombie1"));
            bank.addAccount(user.getGroup(), new AccountW(6, 100, 18, 1, true, "zombie2"));
            bank.addAccount(user.getGroup(), new AccountW(7, 100, 18, 1, true, "zombie3"));
            bank.addAccount(user.getGroup(), new AccountW(8, 100, 18, 1, true, "zombie4"));
        }
        return bank;
    }

    public static void main(String[] args) {
        LinkedHashSet<Integer> test = new LinkedHashSet<Integer>();
        Random random = new Random();
        int actions = 8;
        int[] rsl = new int[actions];
        int ii = 0;
        do {
            test.add(random.nextInt(actions) + 1);
        }
        while (test.size() != actions);
        for (var i : test) {
            rsl[ii] = (int) i;
            ii++;
        }
    }
}
