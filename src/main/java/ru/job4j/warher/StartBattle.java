package ru.job4j.warher;

public class StartBattle {
    public static void main(String[] args) {
        CreateRound round = new CreateRound();
        round.registerBattle();
        int numberRound = 1;
        for (int i = 0; i <= 12; i++) {

            round.registerRound(numberRound++);
            round.battleRound1To2();

        }
    }
}
