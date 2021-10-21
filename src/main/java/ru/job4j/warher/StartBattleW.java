package ru.job4j.warher;

public class StartBattleW {
    public static void main(String[] args) {
        CreateRoundW round = new CreateRoundW();
        round.registerBattle();
        int numberRound = 1;
        for (int i = 0; i < 1; i++) {

            round.registerRound(numberRound++);
            round.battleRound1To2();

        }
    }
}
