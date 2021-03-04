package ru.job4j.waric;

import ru.job4j.io.Matches;

import java.util.Scanner;

public class Battle {
    public void prepare(Scanner input) {
        boolean exitMenu = true;
        this.showMenu();
        int answer = Integer.parseInt(input.nextLine());
        if (answer == 1) {
            System.out.println("\nНачинаем бой");
//            while (exitMenu) {
//
//            }
        } else if (answer == 2) {
            System.out.println("Выход");
            exitMenu = false;
        } else {
            System.out.println("\nВведите от 1 до 2");
        }
    }

    private void showMenu() {
        System.out.println("\nВыберите пункт меню + <Enter> чтобы начать: ");
        System.out.println("1. Начать бой");
        System.out.println("2. Выйти");
        System.out.print("Ваш выбор: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new Battle().prepare(scanner);
    }
}
