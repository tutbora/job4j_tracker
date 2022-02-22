package ru.job4j.temp.set;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String[] blank = generateRandomWords(5);
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(blank));
        Set<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(blank));
        Set<String> treeSet = new TreeSet<>(Arrays.asList(blank));
        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);
        randomUtils(26);
    }

    public static String[] generateRandomWords(int numberOfWords) {
        Random random = new Random();
        String[] randomStrings = new String[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            // words of length 3 through 10.
            char[] word = new char[random.nextInt(8) + 3];
            for (int j = 0; j < word.length; j++) {
                // ASCII 65 - upper letters, 97 - low letters,
                // 26 - volume of english alphabetic characters
                word[j] = (char) (97 + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    public static void randomUtils(int count) {
        int num = -1;
        char[] lineChar = new char[] {'a', 'b', 'c', 'd', 'e', 'f', '1', '2', '3'};
        System.out.println(++num + "." + RandomStringUtils.random(count, lineChar));
        System.out.println(++num + "." + RandomStringUtils.randomAscii(count));
        System.out.println(++num + "." + RandomStringUtils.randomPrint(count));
        System.out.println(++num + "." + RandomStringUtils.randomGraph(count));
        System.out.println(++num + "." + RandomStringUtils.randomNumeric(count));
        System.out.println(++num + "." + RandomStringUtils.randomAlphanumeric(count));
        System.out.println(++num + "." + RandomStringUtils.randomAlphabetic(count));
        System.out.println(++num + "." + RandomStringUtils.random(count, 97, 123, true, true));
    }
}