package ru.job4j.tracker;

public interface Output {
    void println(Object obj);

    Object toString(String name);

    Object toString(int id);
}