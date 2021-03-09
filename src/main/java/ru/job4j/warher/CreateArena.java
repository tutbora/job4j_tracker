package ru.job4j.warher;

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

    public static BankServiceW groups(int choice) {
        int fromRandom = randomNumber(choice);
        int fromRandom2 = randomNumber(choice + 1);
        BankServiceW bank = new BankServiceW();
        if (fromRandom == 1) {
            UserW user = new UserW("1111", "Elf");
            bank.addUser(user);
            bank.addAccount(user.getPassportGroup(), new AccountW("01", 100, 0, 1, true, "wizard"));
            bank.addAccount(user.getPassportGroup(), new AccountW("02", 100, 7, 1, true, "archer1"));
            bank.addAccount(user.getPassportGroup(), new AccountW("03", 100, 7, 1, true, "archer2"));
            bank.addAccount(user.getPassportGroup(), new AccountW("04", 100, 7, 1, true, "archer3"));
            bank.addAccount(user.getPassportGroup(), new AccountW("05", 100, 15, 1, true, "warrior1"));
            bank.addAccount(user.getPassportGroup(), new AccountW("06", 100, 15, 1, true, "warrior2"));
            bank.addAccount(user.getPassportGroup(), new AccountW("07", 100, 15, 1, true, "warrior3"));
            bank.addAccount(user.getPassportGroup(), new AccountW("08", 100, 15, 1, true, "warrior4"));
        }
        if (fromRandom == 2) {
            UserW user2 = new UserW("2222", "Human");
            bank.addUser(user2);
            bank.addAccount(user2.getPassportGroup(), new AccountW("01", 100, 0, 1, true, "wizard"));
            bank.addAccount(user2.getPassportGroup(), new AccountW("02", 100, 5, 1, true, "arbalester1"));
            bank.addAccount(user2.getPassportGroup(), new AccountW("03", 100, 5, 1, true, "arbalester1"));
            bank.addAccount(user2.getPassportGroup(), new AccountW("04", 100, 5, 1, true, "arbalester1"));
            bank.addAccount(user2.getPassportGroup(), new AccountW("05", 100, 18, 1, true, "warrior1"));
            bank.addAccount(user2.getPassportGroup(), new AccountW("06", 100, 18, 1, true, "warrior2"));
            bank.addAccount(user2.getPassportGroup(), new AccountW("07", 100, 18, 1, true, "warrior3"));
            bank.addAccount(user2.getPassportGroup(), new AccountW("08", 100, 18, 1, true, "warrior4"));
        }
        if (fromRandom2 == 3) {
            UserW user3 = new UserW("3333", "Orc");
            bank.addUser(user3);
            bank.addAccount(user3.getPassportGroup(), new AccountW("01", 100, 0, 1, true, "shaman"));
            bank.addAccount(user3.getPassportGroup(), new AccountW("02", 100, 3, 1, true, "archer1"));
            bank.addAccount(user3.getPassportGroup(), new AccountW("03", 100, 3, 1, true, "archer2"));
            bank.addAccount(user3.getPassportGroup(), new AccountW("04", 100, 3, 1, true, "archer3"));
            bank.addAccount(user3.getPassportGroup(), new AccountW("05", 100, 20, 1, true, "goblin1"));
            bank.addAccount(user3.getPassportGroup(), new AccountW("06", 100, 20, 1, true, "goblin2"));
            bank.addAccount(user3.getPassportGroup(), new AccountW("07", 100, 20, 1, true, "goblin3"));
            bank.addAccount(user3.getPassportGroup(), new AccountW("08", 100, 20, 1, true, "goblin4"));
        }
        if (fromRandom2 == 4) {
            UserW user4 = new UserW("4444", "Undead");
            bank.addUser(user4);
            bank.addAccount(user4.getPassportGroup(), new AccountW("01", 100, 0, 1, true, "necromancer"));
            bank.addAccount(user4.getPassportGroup(), new AccountW("02", 100, 4, 1, true, "hunter1"));
            bank.addAccount(user4.getPassportGroup(), new AccountW("03", 100, 4, 1, true, "hunter2"));
            bank.addAccount(user4.getPassportGroup(), new AccountW("04", 100, 4, 1, true, "hunter3"));
            bank.addAccount(user4.getPassportGroup(), new AccountW("05", 100, 18, 1, true, "zombie1"));
            bank.addAccount(user4.getPassportGroup(), new AccountW("06", 100, 18, 1, true, "zombie2"));
            bank.addAccount(user4.getPassportGroup(), new AccountW("07", 100, 18, 1, true, "zombie3"));
            bank.addAccount(user4.getPassportGroup(), new AccountW("08", 100, 18, 1, true, "zombie4"));
        }
        return bank;
    }

    public static void main(String[] args) {
        BankServiceW bank = CreateArena.groups(1);

    }
}
