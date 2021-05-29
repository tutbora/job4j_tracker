package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private final List<Integer> elementList;

    private EasyStream(List<Integer> source) {
        this.elementList = source;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer integer : elementList) {
            rsl.add(fun.apply(integer));
        }
        return new EasyStream(rsl);
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
        return elementList;
    }
}