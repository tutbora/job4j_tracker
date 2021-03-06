package ru.job4j.waric;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id for delete item: ");
        if (tracker.delete(id)) {
            out.println("Good. Deleted id: " + id);
        } else {
            out.println("Not found. Not deleted id: " + id);
        }
        return true;
    }
}
