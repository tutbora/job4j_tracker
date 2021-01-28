package ru.job4j.tracker;

public class StubOutput implements Output {
    private final StringBuilder buffer = new StringBuilder();
    
    @Override
    public void println(Object obj) {
        if (obj != null) {
            buffer.append(obj.toString());
        } else {
            buffer.append("null");
        }
        buffer.append(System.lineSeparator());
    }

    @Override
    public Object toString(String name) {
        return name;
    }

    @Override
    public Object toString(int id) {
        return id;
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}