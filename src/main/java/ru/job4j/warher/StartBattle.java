package ru.job4j.warher;

import java.util.HashSet;
import java.util.Set;

public class StartBattle {
    public static void main(String[] args) {
        BankServiceW bank = CreateArena.groups(1);
        System.out.println(
                "Start battle: "
                        + bank.findByPassport("1111").getRace()
                        + " with "
                        + bank.findByPassport("2222").getRace()
                        + System.lineSeparator());
        for (int i = 0; i < 11; i++) { //TODO i < ?
            int[] rand1 = CreateArena.randomGroup(8);
            int[] rand2 = CreateArena.randomGroup(8);
            for (int ii = 0; ii <= 7; ii++) {
                bank.fight("1111", rand1[ii], "2222", rand2[ii]);
                System.out.println(
                        bank.findByRequisite("1111", rand1[ii]).getUnit()
                                + " отряда "
                                + bank.findByPassport("1111").getRace()
                                + " атакует "
                                + bank.findByRequisite("2222", rand2[ii]).getUnit()
                                + " отряда "
                                + bank.findByPassport("2222").getRace()
                                + System.lineSeparator()
                                + "и наносит урон "
                                + bank.findByRequisite("1111", rand1[ii]).getDamage()
                                + System.lineSeparator()
                                + "у "
                                + bank.findByRequisite("2222", rand2[ii]).getUnit()
                                + " осталось "
                                + bank.findByRequisite("2222", rand2[ii]).getHealth());
            }
        }
    }
}
