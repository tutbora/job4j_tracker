package ru.job4j.warher;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Time;
import java.time.DateTimeException;
import java.util.Date;

import static ru.job4j.warher.CreateArenaW.GROUP1;
import static ru.job4j.warher.CreateArenaW.GROUP2;

public class CreateRoundW {
    private final BattleServiceW battle = CreateArenaW.groups(1);

    public CreateRoundW() {
    }

    public void battleRound1To2() {
        int[] rand1 = RandomW.randomUnit(battle.accountsSize(GROUP1));
        int[] rand2 = RandomW.randomUnit(battle.accountsSize(GROUP2));
        int a = 0;
        int ii = 0;
        for (int j : rand1) {
            if (battle.accountsSize(GROUP2) > 0 && a > battle.accountsSize(GROUP2) - 1) {
                a = 0;
            }
            for (int k = 0; k < 1; k++) {
                battle.fight(GROUP1, j, GROUP2, rand2[a]);
                toConsole1(ii++, rand1, rand2);
                a++;
            }
        }
        rand1 = RandomW.randomUnit(battle.accountsSize(GROUP1));
        rand2 = RandomW.randomUnit(battle.accountsSize(GROUP2));
        int b = 0;
        ii = 0;
        for (int j : rand2) {
            if (battle.accountsSize(GROUP1) > 0 && b > battle.accountsSize(GROUP1) - 1) {
                b = 0;
            }
            for (int k = 0; k < 1; k++) {
                battle.fight(GROUP2, j, GROUP1, rand1[b]);
                toConsole2(ii++, rand1, rand2);
                b++;
            }
        }
    }

    public void registerBattle() {
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream("logWarher.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(out);
        System.out.println(
                "Start battle: "
                        + battle.findByGroup(GROUP1).getRace()
                        + " with "
                        + battle.findByGroup(GROUP2).getRace());
    }

    public void registerRound(int round) {
        System.out.println(
                System.lineSeparator()
                        + "##### Round "
                        + round
                        + " #####"
                        + System.lineSeparator());
    }

    public void win(String win) {
        System.out.println(System.lineSeparator()
                + "WIN "
                + win
                + System.lineSeparator());
    }

    public void toConsole1(int ii, int[] rand1, int[] rand2) {

        System.out.println(ii + ". "
                + battle.findByParam(GROUP1, rand1[ii]).getUnit()
                + " H:"
                + battle.findByParam(GROUP1, rand1[ii]).getHealth()
                + " from "
                + battle.findByGroup(GROUP1).getRace()
                + " group attack "
                + battle.findByParam(GROUP2, rand2[ii]).getUnit()
                + " H:"
                + battle.findByParam(GROUP2, rand2[ii]).getHealth()
                + " from "
                + battle.findByGroup(GROUP2).getRace()
                + " group "
                + System.lineSeparator()
                + "cause loss A:"
                + battle.findByParam(GROUP1, rand1[ii]).getDamage()
                + System.lineSeparator()
                + battle.findByParam(GROUP2, rand2[ii]).getUnit()
                + " stay H:"
                + battle.findByParam(GROUP2, rand2[ii]).getHealth());

    }

    public void toConsole2(int ii, int[] rand1, int[] rand2) {
        System.out.println(ii + ". "
                + battle.findByParam(GROUP2, rand2[ii]).getUnit()
                + " H:"
                + battle.findByParam(GROUP2, rand2[ii]).getHealth()
                + " from "
                + battle.findByGroup(GROUP2).getRace()
                + " group attack "
                + battle.findByParam(GROUP1, rand1[ii]).getUnit()
                + " H:"
                + battle.findByParam(GROUP1, rand1[ii]).getHealth()
                + " from "
                + battle.findByGroup(GROUP1).getRace()
                + " group "
                + System.lineSeparator()
                + "cause loss A:"
                + battle.findByParam(GROUP2, rand2[ii]).getDamage()
                + System.lineSeparator()
                + battle.findByParam(GROUP1, rand1[ii]).getUnit()
                + " stay H:"
                + battle.findByParam(GROUP1, rand1[ii]).getHealth());
    }
}
