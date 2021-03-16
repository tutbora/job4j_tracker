package ru.job4j.tracker;

import java.util.List;

public class ShowAllItemsWA implements UserAction {
    public static final String NL = System.lineSeparator();
    private final Output out;

    public ShowAllItemsWA(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items. By sort W - A.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> resultFindAll = tracker.findAll();
        out.println(NL + "Total items: " + resultFindAll.size());
        resultFindAll.sort(new SortByNameItemWA());
        for (Item item : resultFindAll) {
            out.println(item);
        }
        return true;
    }
}
