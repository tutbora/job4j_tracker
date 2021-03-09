package ru.job4j.waric;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
