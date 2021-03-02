package ru.job4j.warcraftlite;

import java.util.Random;
import java.util.List;

public class StartGame {

    public StartGame() {
    }

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

    public void units() {
    }

    public static void main(String[] args) {
        System.out.println(randomActions(3));
        System.out.println(randomActions(2));
    }
}
