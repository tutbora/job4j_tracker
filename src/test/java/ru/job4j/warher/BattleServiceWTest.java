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
    public void whenDelete2Accounts() {
        UserW user = new UserW("1111", "Elf");
        BattleServiceW bank = new BattleServiceW();
        bank.addUser(user);
        bank.addAccount(user.getGroup(), new AccountW(1, 150D, 15, 1, true, "wizard"));
        bank.addAccount(user.getGroup(), new AccountW(2, 0, 15, 1, true, "wizard"));
        bank.deleteAccount("1111", 2);
        assertNull(bank.findByParam("1111", 2));
    }

    @Test
    public void whenDeleteAccount() {
        BattleServiceW bank = CreateArena.groups(1);
        bank.deleteAccountTest("1111", 2);
        assertThat(bank.accountsSize("1111"), is(7));
    }

    @Test
    public void transferMoney() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("3333", "Orc");
        BattleServiceW bank = new BattleServiceW();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccount(
                user.getGroup(), new AccountW(1, 150D, 15, 1, true, "wizard"));
        bank.addAccount(
                user2.getGroup(), new AccountW(2, 50D, 15, 1, true, "wizard"));
        bank.transferMoney(user.getGroup(), 1, user2.getGroup(), 2, 150D);
        assertThat(bank.findByParam(user2.getGroup(), 2).getHealth(), is(200D));
    }

    @Test
    public void transferMoneyBecameFifty() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("3333", "Orc");
        BattleServiceW bank = new BattleServiceW();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccount(
                user.getGroup(), new AccountW(1, 150D, 15D, 1, true, "wizard"));
        bank.addAccount(
                user2.getGroup(), new AccountW(2, 50D, 15D, 1, true, "wizard"));
        bank.transferMoney(user.getGroup(), 1, user2.getGroup(), 2, 100D);
        assertThat(bank.findByParam(user.getGroup(), 1).getHealth(), is(50D));
    }

    @Test
    public void whenFight() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("3333", "Orc");
        BattleServiceW bank = new BattleServiceW();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccount(user.getGroup(), new AccountW(1, 100D, 15D, 1, true, "wizard"));
        bank.addAccount(user2.getGroup(), new AccountW(1, 10D, 10D, 1, true, "wizard"));
        bank.addAccount(user2.getGroup(), new AccountW(2, 10D, 10D, 1, true, "wizard"));
        bank.fight(user.getGroup(), 1, user2.getGroup(), 2);
        assertNull(bank.findByParam(user2.getGroup(), 2));
    }

    @Test
    public void whenWin1() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("3333", "Orc");
        BattleServiceW bank = new BattleServiceW();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccount(user.getGroup(), new AccountW(1, 100D, 15D, 1, true, "wizard"));
        bank.addAccount(user2.getGroup(), new AccountW(1, 10D, 10D, 1, true, "wizard"));
        bank.fight(user.getGroup(), 1, user2.getGroup(), 1);
        assertThat(bank.accountsSize("3333"), is(0));
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
        BattleServiceW bank = CreateArena.groups(1);
        bank.fight("1111", 3, "2222", 6);
        assertThat(bank.findByParam("2222", 6).getHealth(), is(20D));
    }
}