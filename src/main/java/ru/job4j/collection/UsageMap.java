package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> id = new HashMap<>();
        id.put("tutbora@yandex.com", "Ruslan Zubovich");
        for (String key : id.keySet()) {
            System.out.println(key + " = " + id.get(key));
        }
    }
}
