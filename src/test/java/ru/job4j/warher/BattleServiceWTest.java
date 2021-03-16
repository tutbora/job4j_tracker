package ru.job4j.warher;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class BattleServiceWTest {

    @Test
    public void whenAddUser() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("2222", "Human");
        BattleServiceW bank = new BattleServiceW();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addUser(user);
        assertThat(bank.findByGroup("1111"), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        UserW user = new UserW("1111", "Elf");
        BattleServiceW bank = new BattleServiceW();
        bank.addUser(user);
        bank.addAccount(user.getGroup(), new AccountW(1, 150D, 15, 1, true, "wizard"));
        assertNull(bank.findByParam("34", 1));
    }

    @Test
    public void whenAddAccount() {
        UserW user = new UserW("1111", "Elf");
        BattleServiceW bank = new BattleServiceW();
        bank.addUser(user);
        bank.addAccount(user.getGroup(), new AccountW(1, 150D, 15, 1, true, "wizard"));
        assertThat(bank.findByParam("1111", 1).getHealth(), is(150D));
    }

    @Test
    public void whenAdd2Accounts() {
        UserW user = new UserW("1111", "Elf");
        BattleServiceW bank = new BattleServiceW();
        bank.addUser(user);
        bank.addAccount(user.getGroup(), new AccountW(1, 150D, 15, 1, true, "wizard"));
        bank.addAccount(user.getGroup(), new AccountW(2, 150D, 15, 1, true, "wizard"));
        assertThat(bank.findByParam("1111", 2).getHealth(), is(150D));
    }

    @Test
    public void whenFight() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("3333", "Orc");
        BattleServiceW bank = new BattleServiceW();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccount(user.getGroup(), new AccountW(0, 100D, 15D, 1, true, "wizard"));
        bank.addAccount(user2.getGroup(), new AccountW(0, 100D, 10D, 1, true, "wizard"));
        bank.addAccount(user2.getGroup(), new AccountW(1, 10D, 10D, 1, true, "wizard"));
        bank.fight(user.getGroup(), 0, user2.getGroup(), 0);
        assertThat(bank.findByParam(user2.getGroup(), 0).getPriority(), is(1));
    }

    @Test
    public void whenWinElf() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("3333", "Orc");
        BattleServiceW bank = new BattleServiceW();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccount(user.getGroup(), new AccountW(0, 100D, 15D, 1, true, "wizard1"));
        bank.addAccount(user2.getGroup(), new AccountW(0, 10D, 10D, 1, true, "wizard2"));
        bank.addAccount(user2.getGroup(), new AccountW(1, 10D, 10D, 0, true, "wizard3"));
        bank.fight(user.getGroup(), 0, user2.getGroup(), 0);
        assertThat(bank.win(user.getGroup(), user2.getGroup()), is(true));
    }

    @Test
    public void whenFightAndDelete() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("3333", "Orc");
        BattleServiceW bank = new BattleServiceW();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccount(
                user.getGroup(), new AccountW(1, 100D, 15D, 1, true, "wizard"));
        bank.addAccount(
                user2.getGroup(), new AccountW(2, 90D, 10D, 1, true, "wizard"));
        bank.fight(user.getGroup(), 1, user2.getGroup(), 2);
        assertThat(bank.findByParam(user2.getGroup(), 2).getHealth(), is(75D));
    }

    @Test
    public void whenFightAuto() {
        BattleServiceW bank = CreateArena.groups(3);
        bank.fight("1111", 3, "2222", 6);
        assertThat(bank.findByParam("2222", 6).getHealth(), is(20D));
    }
}