package ru.job4j.temp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CalcDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pixelLength, smLength, pixelHeight, smHeight, inchDiagonal, smDiagonal, smStep;
        double smInInch = 2.54;
        System.out.println("Расчет размера дисплея монитора.");
        System.out.println("Пример данных для расчета: разрешение 1920х1080, "
                + "диагональ 24\"");
        System.out.print("Введите длину в пикселях: ");
        pixelLength = scanner.nextDouble();
        System.out.print("Введите высоту в пикселях: ");
        pixelHeight = scanner.nextDouble();
        System.out.print("Введите диагональ в дюймах: ");
        inchDiagonal = scanner.nextDouble();
        smDiagonal = inchDiagonal * smInInch;
        double diagonalRelativity = Math.sqrt(pixelLength * pixelLength + pixelHeight * pixelHeight);
        smStep = smDiagonal / diagonalRelativity;
        smLength = pixelLength * smStep;
        smHeight = pixelHeight * smStep;
        double pixelsOnSm = pixelLength / smLength * pixelHeight / smHeight;
        double pixelsOnInch = pixelLength / smLength * smInInch * pixelHeight / smHeight * smInInch;
        System.out.println("Длина расчетная, см: " + round(smLength, 1));
        System.out.println("Высота расчетная, см: " + round(smHeight, 1));
        System.out.println("Диагональ расчетная, см: "
                + round(Math.sqrt(smLength * smLength + smHeight * smHeight), 1));
        System.out.println("Пикселей на см2: " + round(pixelsOnSm, 0));
        System.out.println("Пикселей на дюйм2: " + round(pixelsOnInch, 0));
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