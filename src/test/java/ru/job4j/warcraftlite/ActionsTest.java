package ru.job4j.warcraftlite;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ActionsTest {

    @Test
    public void whenAddRace() {
        Unit unit1 = new Unit("Elf");
        Unit unit2 = new Unit("Human");
        Unit unit3 = new Unit("Orc");
        Unit unit4 = new Unit("Undead");
        Actions actions = new Actions();
        actions.addUnit(unit1);
        actions.addUnit(unit2);
        actions.addUnit(unit3);
        actions.addUnit(unit4);
        assertThat(actions.findByRace("Elf"), is(unit1));
    }

    @Test
    public void whenAddAccount() {
        Unit unit = new Unit("Elf");
        Actions actions = new Actions();
        actions.addUnit(unit);
        actions.addAccount(unit.getRace(), new Account("wizard", 100, 2, 1, false));
        actions.addAccount(unit.getRace(), new Account("archer1", 100, 2, 1, false));
        actions.addAccount(unit.getRace(), new Account("archer2", 100, 2, 1, false));
        actions.addAccount(unit.getRace(), new Account("archer3", 100, 2, 1, false));
        actions.addAccount(unit.getRace(), new Account("warrior1", 100, 1, 1, false));
        actions.addAccount(unit.getRace(), new Account("warrior2", 100, 1, 1, false));
        actions.addAccount(unit.getRace(), new Account("warrior3", 100, 1, 1, false));
        actions.addAccount(unit.getRace(), new Account("warrior4", 100, 1, 1, false));
        assertThat(actions.findByUnitName("Elf", "archer1").getHealth(), is(100));
    }

    @Test
    public void whenAddGroupElf() {
    var acc = Actions.addGroup(11);
    assertThat(acc.findByUnitName("Elf", "archer1").getHealth(), is(100));
    }

    @Test
    public void whenAddGroupOrc() {
        var acc = Actions.addGroup(21);
        assertThat(acc.findByUnitName("Orc", "goblin4").getHealth(), is(100));
    }
}