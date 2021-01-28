package ru.job4j.tracker;

public class ConsoleOutput implements Output {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }

    @Override
    public Object toString(String name) {
        return name;
    }

    @Override
    public Object toString(int id) {
        return id;
    }
}