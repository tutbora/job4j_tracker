package ru.job4j.waric;

public class FindById implements UserAction {
    private final Output out;

    public FindById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id for find item: ");
        Item resultFind = tracker.findById(id);
        if (resultFind != null) {
            out.println("Result find by id: " + resultFind);
        } else {
            out.println("Not found id: " + id);
        }
        return true;
    }
}
