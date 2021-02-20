package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public final class Tracker {
    private static Tracker tracker = null;
    private int ids = 1;
    private final List<Item> items = new ArrayList<>();

    protected Tracker() {
    }

    public static Tracker getTracker() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item it : items) {
            if (it.getName().contains(key)) {
                rsl.add(it);
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        int index = 0;
        for (Item it : items) {
            if (it.getId() == id) {
                rsl = index;
                break;
            }
            index++;
        }
        return rsl;
    }

    public boolean replace(int id, Item bugWithDesc) {
        int finder = indexOf(id);
        boolean rsl = finder != -1;
        if (rsl) {
            bugWithDesc.setId(id);
            items.set(finder, bugWithDesc);
            }
                return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (index != -1) {
            items.remove(index);
        }
            return rsl;
    }
}