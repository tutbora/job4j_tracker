package ru.job4j.waric;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name for create: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Created: " + item);
        return true;
    }
}