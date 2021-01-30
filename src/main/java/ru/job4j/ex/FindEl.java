package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (String i : value) {
            if (i.equals(key)) {
                rsl = 1;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"q", "w", "e", "r", "t"};
        String key = "k";
        try {
            int rsl = indexOf(value, key);
            System.out.println(rsl);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}