package ru.job4j.tracker;

public class ExitProgram implements UserAction {

    public ExitProgram(Output out) {
    }

    @Override
    public String name() {
        return "Exit Program." + System.lineSeparator();
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
