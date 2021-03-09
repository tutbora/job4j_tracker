package ru.job4j.warher;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class BankServiceWTest {

    @Test
    public void whenAddUser() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("2222", "Human");
        BankServiceW bank = new BankServiceW();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addUser(user);
        assertThat(bank.findByPassport("1111"), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        UserW user = new UserW("1111", "Elf");
        BankServiceW bank = new BankServiceW();
        bank.addUser(user);
        bank.addAccount(user.getGroup(), new AccountW(1, 150D, 15, 1, true, "wizard"));
        assertNull(bank.findByRequisite("34", 1));
    }

    @Test
    public void addAccount() {
        UserW user = new UserW("1111", "Elf");
        BankServiceW bank = new BankServiceW();
        bank.addUser(user);
        bank.addAccount(user.getGroup(), new AccountW(1, 150D, 15, 1, true, "wizard"));
        assertThat(bank.findByRequisite("1111", 1).getHealth(), is(150D));
    }

    @Test
    public void add2Accounts() {
        UserW user = new UserW("1111", "Elf");
        BankServiceW bank = new BankServiceW();
        bank.addUser(user);
        bank.addAccount(user.getGroup(), new AccountW(1, 150D, 15, 1, true, "wizard"));
        bank.addAccount(user.getGroup(), new AccountW(2, 150D, 15, 1, true, "wizard"));
        assertThat(bank.findByRequisite("1111", 2).getHealth(), is(150D));
    }

    @Test
    public void transferMoney() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("3333", "Orc");
        BankServiceW bank = new BankServiceW();
        bank.addUser(user);
        bank.addUser(user2);
        //bank.addAccount(user.getPassportGroup(), new AccountW("5546", 150D));
        //bank.addAccount(user.getPassportGroup(), new AccountW("113", 50D));
        bank.addAccount(
                user.getGroup(), new AccountW(1, 150D, 15, 1, true, "wizard"));
        bank.addAccount(
                user2.getGroup(), new AccountW(2, 50D, 15, 1, true, "wizard"));
        bank.transferMoney(user.getGroup(), 1, user2.getGroup(), 2, 150D);
        assertThat(bank.findByRequisite(user2.getGroup(), 2).getHealth(), is(200D));
    }

    @Test
    public void transferMoneyBecameFifty() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("3333", "Orc");
        BankServiceW bank = new BankServiceW();
        bank.addUser(user);
        bank.addUser(user2);
//        bank.addAccount(user.getPassportGroup(), new AccountW("5546", 150D));
//        bank.addAccount(user.getPassportGroup(), new AccountW("113", 50D));
        bank.addAccount(
                user.getGroup(), new AccountW(1, 150D, 15D, 1, true, "wizard"));
        bank.addAccount(
                user2.getGroup(), new AccountW(2, 50D, 15D, 1, true, "wizard"));
        bank.transferMoney(user.getGroup(), 1, user2.getGroup(), 2, 100D);
        assertThat(bank.findByRequisite(user.getGroup(), 1).getHealth(), is(50D));
    }

    @Test
    public void whenFight() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("3333", "Orc");
        BankServiceW bank = new BankServiceW();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccount(
                user.getGroup(), new AccountW(1, 100D, 15D, 1, true, "wizard"));
        bank.addAccount(
                user2.getGroup(), new AccountW(2, 90, 10D, 1, true, "wizard"));
        bank.fight(user.getGroup(), 1, user2.getGroup(), 2);
        assertThat(bank.findByRequisite(user2.getGroup(), 2).getHealth(), is(75D));
    }

    @Test
    public void whenCreateArena() {
        BankServiceW bank = CreateArena.groups(1);
        bank.fight("1111", 3, "2222", 6);
        assertThat(bank.findByRequisite("2222", 6).getHealth(), is(95D));
    }
}