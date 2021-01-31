package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItem(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExitProgram() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu."
                        + System.lineSeparator()
                        + "0. Exit Program."
                        + System.lineSeparator()
        ));
}

    @Test
    public void whenShowAllItems() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("ShowAllItems item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllItems(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String menu = "Menu."
                + System.lineSeparator()
                + "0. Show all items."
                + System.lineSeparator()
                + "1. Exit Program."
                + System.lineSeparator()
                + System.lineSeparator()
                + "Total items: 1"
                + System.lineSeparator()
                + item1
                + System.lineSeparator()
                + "Menu."
                + System.lineSeparator()
                + "0. Show all items."
                + System.lineSeparator()
                + "1. Exit Program."
                + System.lineSeparator();
        assertThat(out.toString(), is(menu));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Find"));
        Item item2 = tracker.add(new Item("Find"));
        Input in = new StubInput(
                new String[] {"0", "Find", "1"}
        );
        UserAction[] actions = {
                new FindByName(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String menu = "Menu."
                + System.lineSeparator()
                + "0. Find items by name."
                + System.lineSeparator()
                + "1. Exit Program."
                + System.lineSeparator()
                + "Result find by name: "
                + item1
                + System.lineSeparator()
                + "Result find by name: "
                + item2
                + System.lineSeparator()
                + "Menu."
                + System.lineSeparator()
                + "0. Find items by name."
                + System.lineSeparator()
                + "1. Exit Program."
                + System.lineSeparator();
        assertThat(out.toString(), is(menu));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("FindId"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindById(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String menu = "Menu."
                + System.lineSeparator()
                + "0. Find item by Id."
                + System.lineSeparator()
                + "1. Exit Program."
                + System.lineSeparator()
                + "Result find by id: "
                + item
                + System.lineSeparator()
                + "Menu."
                + System.lineSeparator()
                + "0. Find item by Id."
                + System.lineSeparator()
                + "1. Exit Program."
                + System.lineSeparator();
        assertThat(out.toString(), is(menu));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        /* Пункты меню: неверный, верный.*/
        Input in = new StubInput(
                new String[] {"9", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                    "Menu."
                        + System.lineSeparator()
                        + "0. Exit Program."
                        + System.lineSeparator()
                        + "Wrong input, you can select: 0 .. 0"
                        + System.lineSeparator()
                        + "Menu."
                        + System.lineSeparator()
                        + "0. Exit Program."
                        + System.lineSeparator()
        ));
    }
}