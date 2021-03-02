package ru.job4j.warcraftlite;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ActionsTest {

    @Test
    public void whenAddUnit() {
        Unit unit1 = new Unit("001", "Elf Wizard");
        Unit unit2 = new Unit("002", "Elf Archer");
        Unit unit3 = new Unit("003", "Elf Archer");
        Unit unit4 = new Unit("004", "Elf Archer");
        Unit unit5 = new Unit("005", "Elf Warrior");
        Unit unit6 = new Unit("006", "Elf Warrior");
        Unit unit7 = new Unit("007", "Elf Warrior");
        Unit unit8 = new Unit("008", "Elf Warrior");
        Actions actions = new Actions();
        actions.addUnit(unit1);
        actions.addUnit(unit2);
        actions.addUnit(unit3);
        actions.addUnit(unit4);
        actions.addUnit(unit5);
        actions.addUnit(unit6);
        actions.addUnit(unit7);
        actions.addUnit(unit8);
        actions.addUnit(unit1);
        assertThat(actions.findByPosition("001"), is(unit1));
    }
}