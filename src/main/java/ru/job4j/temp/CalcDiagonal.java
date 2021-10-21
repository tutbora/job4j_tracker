package ru.job4j.temp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CalcDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pxlLength, smLength, pxlHeight, smHeight, inchDiagonal, smDiagonal, smStep;
        print(2, "Расчет размера дисплея монитора.");
        print(2, "Пример данных для расчета: разрешение 1920х1080, "
                + "диагональ 23.6\"");
        print(1, "Введите длину в пикселях: ");
        pxlLength = scanner.nextDouble();
        print(1, "Введите высоту в пикселях: ");
        pxlHeight = scanner.nextDouble();
        print(1, "Введите диагональ в дюймах: ");
        inchDiagonal = scanner.nextDouble();
        smDiagonal = goToSm(inchDiagonal);
        double pxlDiagonal = Math.sqrt(pxlLength * pxlLength + pxlHeight * pxlHeight);
        smStep = smDiagonal / pxlDiagonal;
        smLength = pxlLength * smStep;
        smHeight = pxlHeight * smStep;
        double pxlsOnSm = pxlLength / smLength * pxlHeight / smHeight;
        double pxlsOnInch = goToSm(pxlLength / smLength) * goToSm(pxlHeight / smHeight);
        System.out.println("Длина расчетная, см: " + round(smLength, 1));
        print(2, "Высота расчетная, см: " + round(smHeight, 1));
        print(2, "Диагональ расчетная, см: "
                + round(Math.sqrt(smLength * smLength + smHeight * smHeight), 1));
        print(2, "Пикселей на см2: " + round(pxlsOnSm, 0));
        print(2, "Пикселей на дюйм2: " + round(pxlsOnInch, 0));
    }

    private static void print(int line, String text) {
        if (line == 1) {
            System.out.print(text);
        }
        if (line == 2) {
            System.out.println(text);
        }
    }

    private static double goToSm(double inch) {
        return inch * 2.54;
    }

    private static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}