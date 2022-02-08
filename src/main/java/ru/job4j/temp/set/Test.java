package ru.job4j.temp.set;

import org.apache.commons.lang.RandomStringUtils;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String[] blank = generateRandomWords(10);
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(blank));
        Set<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(blank));
        Set<String> treeSet = new TreeSet<>(Arrays.asList(blank));

        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);
        random(55);
    }

    public static String[] generateRandomWords(int numberOfWords) {
        Random random = new Random();
        String[] randomStrings = new String[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            // words of length 3 through 10.
            char[] word = new char[random.nextInt(8) + 3];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    public static void random(int count) {
        System.out.println(RandomStringUtils.randomAscii(count));
        System.out.println(RandomStringUtils.randomNumeric(count));
        System.out.println(RandomStringUtils.randomAlphanumeric(count));
        System.out.println(RandomStringUtils.randomAlphabetic(count));
        System.out.println(RandomStringUtils.random(count, 97, 123, true, true));
    }
}