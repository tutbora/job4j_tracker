package ru.job4j.tracker;

import java.util.List;

public class ShowAllItems implements UserAction {
    public static final String NL = System.lineSeparator();
    private final Output out;

    public ShowAllItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> resultFindAll = tracker.findAll();
        out.println(NL + "Total items: " + resultFindAll.size());
        for (Item item : resultFindAll) {
            out.println(item);
        }
        return true;
    }
}
