package ru.job4j.temp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CalcDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pxlLength, smLength, pxlHeight, smHeight, inchDiagonal, smDiagonal, smStep;
        printLineOrNot(2, "Расчет размера дисплея монитора.");
        printLineOrNot(2, "Пример данных для расчета: разрешение 1920х1080, "
                + "диагональ 23.6\"");
        printLineOrNot(1, "Введите длину в пикселях: ");
        pxlLength = scanner.nextFloat();
        printLineOrNot(1, "Введите ширину в пикселях: ");
        pxlHeight = scanner.nextDouble();
        printLineOrNot(1, "Введите диагональ в дюймах: ");
        inchDiagonal = scanner.nextDouble();
        smDiagonal = goToSm(inchDiagonal);
        double pxlDiagonal = Math.sqrt(pxlLength * pxlLength + pxlHeight * pxlHeight);
        smStep = smDiagonal / pxlDiagonal;
        smLength = pxlLength * smStep;
        smHeight = pxlHeight * smStep;
        double pxlsOnSm = pxlLength / smLength * pxlHeight / smHeight;
        double pxlsOnInch = goToSm(pxlLength / smLength) * goToSm(pxlHeight / smHeight);
        toConsole(smLength, smHeight, pxlsOnSm, pxlsOnInch, pxlLength, pxlHeight);
    }

    private static void printLineOrNot(int line, String text) {
        if (line == 1) {
            System.out.print(text);
        } else if (line == 2) {
            System.out.println(text);
        } else {
            System.out.println("Error input");
        }
    }

    private static void toConsole(double smLength, double smHeight, double pxlsOnSm,
                                  double pxlsOnInch, double pxlLength, double pxlHeight) {
        printLineOrNot(2, "Длина расчетная, см: " + round(smLength, 1));
        printLineOrNot(2, "Ширина расчетная, см: " + round(smHeight, 1));
        printLineOrNot(2, "Диагональ расчетная, см: "
                + round(Math.sqrt(smLength * smLength + smHeight * smHeight), 1));
        printLineOrNot(2, "Пикселей на см2: " + round(pxlsOnSm, 0));
        printLineOrNot(2, "Пикселей на дюйм2: " + round(pxlsOnInch, 0));
        printLineOrNot(2, "Всего пикселей: " + round(pxlLength * pxlHeight, 0));
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