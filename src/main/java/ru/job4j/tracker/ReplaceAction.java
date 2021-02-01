package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id for edit item: ");
        Item newItem = new Item(input.askStr("Enter new name: "));
        if (tracker.replace(id, newItem)) {
            out.println("Good. Edit end");
        } else {
            out.println("Error. Edit end");
        }
        return true;
    }
}