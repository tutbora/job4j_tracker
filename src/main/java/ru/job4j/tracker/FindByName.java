package ru.job4j.tracker;

import java.util.List;

public class FindByName implements UserAction {
    private final Output out;

    public FindByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String newName = input.askStr("Enter name for find: ");
        List<Item> resultFind = tracker.findByName(newName);
        if (resultFind.size() > 0) {
            for (Item item : resultFind) {
                out.println("Found: " + item);
            }
        } else {
            out.println("Not found name: " + newName);
        }
        return true;
    }
}
