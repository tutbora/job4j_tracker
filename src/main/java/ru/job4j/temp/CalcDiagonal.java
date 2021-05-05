package ru.job4j.temp;

import java.util.Scanner;

public class CalcDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, d;
        System.out.println("Расчет размера дисплея монитора.");
        System.out.println("Пример данных для расчета: разрешение 1920х1080, "
                + "соотношение 16:9, диагональ 24\"");
        System.out.print("Введите длину: ");
        a = scanner.nextDouble();
        System.out.print("Введите высоту: ");
        b = scanner.nextDouble();
        System.out.print("Введите диагональ в дюймах: ");
        d = scanner.nextDouble();
        double transferToSm = d * 2.54;
        double diagonalRelativity = Math.sqrt(a * a + b * b);
        double step = transferToSm / diagonalRelativity;
        double a1 = a * step;
        double b1 = b * step;
        System.out.println("Длина расчетная, см: " + a1);
        System.out.println("Высота расчетная, см: " + b1);
        System.out.println("Диагональ расчетная, см: " + Math.sqrt(a1 * a1 + b1 * b1));
    }
}
