package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitProgram(output)
        };
        new StartUI(output).init(in, tracker, actions);
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
        String showAllItems = "ShowAllItems item";
        Item item = tracker.add(new Item(showAllItems));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllItems(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(tracker.findById(item.getId()).getName()), is(showAllItems));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String findByName = "Find";
        Item item = tracker.add(new Item(findByName));
        tracker.add(new Item(findByName));
        Input in = new StubInput(
                new String[] {"0", findByName, "1"}
        );
        UserAction[] actions = {
                new FindByName(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(tracker.findById(item.getId()).getName()), is(findByName));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String findById = "FindId";
        Item item = tracker.add(new Item(findById));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindById(out),
                new ExitProgram(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(item.getId()), is(1));
    }
}