package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private static List<Integer> elementList;

    private EasyStream(List<Integer> source) {
        elementList.addAll(source);
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        for (int i = 0; i < elementList.size(); i++) {
            Integer integer = elementList.get(i);
            elementList.set(i, fun.apply(integer));
        }
        return new EasyStream(elementList);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer integer : elementList) {
            if (fun.test(integer)) {
                rsl.add(integer);
            }
        }
        return new EasyStream(rsl);
    }

    public List<Integer> collect() {
        return new ArrayList<>(elementList);
    }
}