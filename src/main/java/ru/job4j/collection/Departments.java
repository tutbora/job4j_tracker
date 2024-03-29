package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                String element = start + el;
                tmp.add(element);
                start = el + "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    public static List<String> sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
        return orgs;
    }

    public static List<String> sortDesc(List<String> orgs) {
        DepDescComp depDescComp = new DepDescComp();
        orgs.sort(depDescComp);
        return orgs;
    }
}