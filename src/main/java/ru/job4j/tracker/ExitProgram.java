package ru.job4j.tracker;

public class ExitProgram implements UserAction {

    public ExitProgram(Output out) {
    }

    @Override
    public String name() {
        return "Exit Program.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
