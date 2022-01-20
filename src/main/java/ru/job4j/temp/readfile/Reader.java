package ru.job4j.temp.readfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args) {
        String sep = File.separator;
        String path = "unt";
        Path javaInfo = Paths.get("U:" + sep + "5..Student" + sep + "Interview" + sep + "Untitled-1.txt");
        File file = new File(javaInfo.toString());

        try {
            Scanner scanner = new Scanner(file);
//            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
//            }
            System.out.println("File \"" + file + "\" is found!");
            String line = scanner.nextLine();
            String[] words = line.split("[ .+]");
            for (String w : words) {
                System.out.println(w);
            }
            System.out.println(Arrays.toString(words));

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File \"" + file + "\" or way is not found!");
        }
    }
}
