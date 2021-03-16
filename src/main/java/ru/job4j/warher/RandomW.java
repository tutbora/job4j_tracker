package ru.job4j.warher;

import java.util.LinkedHashSet;
import java.util.Random;

public class RandomW {

    public static int randomRace(int actions) {
        int rsl = 1;
        Random rand = new Random();
        if (actions == 1) {
            rsl = rand.nextInt(actions + 1) + 1;
        }
        if (actions == 2) {
            rsl = rand.nextInt(actions) + 3;
        }
        if (actions == 3) {
            rsl = 2;
        }
        if (actions == 4) {
            rsl = 4;
        }
        return rsl;
    }

    public static int[] randomUnit(int actions) {
        LinkedHashSet<Integer> forArray = new LinkedHashSet<>();
        Random random = new Random();
        int[] rsl = new int[actions];
        int ii = 0;
        do {
            forArray.add(random.nextInt(actions));
        }
        while (forArray.size() != actions);
        for (var i : forArray) {
            rsl[ii] = i;
            ii++;
        }
        return rsl;
    }
}
