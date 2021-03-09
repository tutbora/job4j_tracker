package ru.job4j.waric;

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
