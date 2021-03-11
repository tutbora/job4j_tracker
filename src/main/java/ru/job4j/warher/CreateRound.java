package ru.job4j.warher;

import static ru.job4j.warher.CreateArena.GROUP1;
import static ru.job4j.warher.CreateArena.GROUP2;

public class CreateRound {
    private final BattleServiceW bank = CreateArena.groups(1);

    public CreateRound() {
    }

    public void battleRound1To2() {
        int[] rand1 = BattleServiceW.randomUnit(bank.accountsSize(GROUP1));
        int[] rand2 = BattleServiceW.randomUnit(bank.accountsSize(GROUP2));
        int a = 0;
        int ii = 0;
        for (int j : rand1) {
            if (bank.accountsSize(GROUP2) > 0 && a > bank.accountsSize(GROUP2) - 1) {
                a = 0;
            }
            for (int k = 0; k < 1; k++) {
                bank.fight(GROUP1, j, GROUP2, rand2[a]);
                toConsole1(ii++, rand1, rand2);
                a++;
            }
        }
        rand1 = BattleServiceW.randomUnit(bank.accountsSize(GROUP1));
        rand2 = BattleServiceW.randomUnit(bank.accountsSize(GROUP2));
        int b = 0;
        ii = 0;
        for (int j : rand2) {
            if (bank.accountsSize(GROUP1) > 0 && b > bank.accountsSize(GROUP1) - 1) {
                b = 0;
            }
            for (int k = 0; k < 1; k++) {
                bank.fight(GROUP2, j, GROUP1, rand1[b]);
                toConsole2(ii++, rand1, rand2);
                b++;
            }
        }

//            for (int i = 0; i < bank.accountsSize(GROUP1); i++) {
//                bank.fight(GROUP1, rand1[i], GROUP2, rand2[i]);
//                toConsole1(i, rand1, rand2);
//            }
    }

//    public void battleRound2To1() {
//        int[] rand1 = BattleServiceW.randomUnit(bank.accountsSize(GROUP1));
//        int[] rand2 = BattleServiceW.randomUnit(bank.accountsSize(GROUP2));
//            for (int ii = 0; ii < bank.accountsSize(GROUP2); ii++) {
//                bank.fight(GROUP2, rand2[ii], GROUP1, rand1[ii]);
//                toConsole2(ii, rand1, rand2);
//            }
//    }

    public void registerBattle() {
        System.out.println(
                "Start battle: "
                        + bank.findByGroup(GROUP1).getRace()
                        + " with "
                        + bank.findByGroup(GROUP2).getRace());
    }

    public void registerRound(int round) {
        System.out.println(
                System.lineSeparator()
                        + "##### Round "
                        + round
                        + " #####"
                        + System.lineSeparator());
    }

    public void win(int win) {
        System.out.println(System.lineSeparator()
                + "WIN "
                + win
                + System.lineSeparator());
    }

    public void toConsole1(int ii, int[] rand1, int[] rand2) {
        System.out.println(ii + ". "
                + bank.findByParam(GROUP1, rand1[ii]).getUnit()
                + " отряда "
                + bank.findByGroup(GROUP1).getRace()
                + " атакует "
                + bank.findByParam(GROUP2, rand2[ii]).getUnit()
                + " отряда "
                + bank.findByGroup(GROUP2).getRace()
                + System.lineSeparator()
                + "и наносит урон "
                + bank.findByParam(GROUP1, rand1[ii]).getDamage()
                + System.lineSeparator()
                + "у "
                + bank.findByParam(GROUP2, rand2[ii]).getUnit()
                + " осталось "
                + bank.findByParam(GROUP2, rand2[ii]).getHealth());
    }

    public void toConsole2(int ii, int[] rand1, int[] rand2) {
        System.out.println(ii + ". "
                + bank.findByParam(GROUP2, rand2[ii]).getUnit()
                + " отряда "
                + bank.findByGroup(GROUP2).getRace()
                + " атакует "
                + bank.findByParam(GROUP1, rand1[ii]).getUnit()
                + " отряда "
                + bank.findByGroup(GROUP1).getRace()
                + System.lineSeparator()
                + "и наносит урон "
                + bank.findByParam(GROUP2, rand2[ii]).getDamage()
                + System.lineSeparator()
                + "у "
                + bank.findByParam(GROUP1, rand1[ii]).getUnit()
                + " осталось "
                + bank.findByParam(GROUP1, rand1[ii]).getHealth());
    }
}
