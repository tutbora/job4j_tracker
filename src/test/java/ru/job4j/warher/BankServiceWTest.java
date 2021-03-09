package ru.job4j.warher;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class BankServiceWTest {

    @Test
    public void addUser() {
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
        bank.addAccount(user.getPassportGroup(), new AccountW("01", 150D, 15, 1, true, "wizard"));
        assertNull(bank.findByRequisite("34", "01"));
    }

    @Test
    public void addAccount() {
        UserW user = new UserW("1111", "Elf");
        BankServiceW bank = new BankServiceW();
        bank.addUser(user);
        bank.addAccount(user.getPassportGroup(), new AccountW("01", 150D, 15, 1, true, "wizard"));
        assertThat(bank.findByRequisite("1111", "01").getBalanceHealth(), is(150D));
    }

    @Test
    public void add2Accounts() {
        UserW user = new UserW("1111", "Elf");
        BankServiceW bank = new BankServiceW();
        bank.addUser(user);
        bank.addAccount(user.getPassportGroup(), new AccountW("01", 150D, 15, 1, true, "wizard"));
        bank.addAccount(user.getPassportGroup(), new AccountW("02", 150D, 15, 1, true, "wizard"));
        assertThat(bank.findByRequisite("1111", "02").getBalanceHealth(), is(150D));
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
                user.getPassportGroup(), new AccountW("01", 150D, 15, 1, true, "wizard"));
        bank.addAccount(
                user2.getPassportGroup(), new AccountW("02", 50D, 15, 1, true, "wizard"));
        bank.transferMoney(user.getPassportGroup(), "01", user2.getPassportGroup(), "02", 150D);
        assertThat(bank.findByRequisite(user2.getPassportGroup(), "02").getBalanceHealth(), is(200D));
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
                user.getPassportGroup(), new AccountW("01", 150D, 15D, 1, true, "wizard"));
        bank.addAccount(
                user2.getPassportGroup(), new AccountW("02", 50D, 15D, 1, true, "wizard"));
        bank.transferMoney(user.getPassportGroup(), "01", user2.getPassportGroup(), "02", 100D);
        assertThat(bank.findByRequisite(user.getPassportGroup(), "01").getBalanceHealth(), is(50D));
    }

    @Test
    public void whenFight() {
        UserW user = new UserW("1111", "Elf");
        UserW user2 = new UserW("3333", "Orc");
        BankServiceW bank = new BankServiceW();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccount(
                user.getPassportGroup(), new AccountW("01", 100D, 15D, 1, true, "wizard"));
        bank.addAccount(
                user2.getPassportGroup(), new AccountW("02", 90, 10D, 1, true, "wizard"));
        bank.fight(user.getPassportGroup(), "01", user2.getPassportGroup(), "02");
        assertThat(bank.findByRequisite(user2.getPassportGroup(), "02").getBalanceHealth(), is(75D));
    }

    @Test
    public void whenCreateArena() {
        UserW user = new UserW();
        UserW user2 = new UserW();
        BankServiceW bank = CreateArena.groups(1);

        bank.fight(user.getPassportGroup(), "01", user2.getPassportGroup(), "02");
        assertThat(bank.findByRequisite(user2.getPassportGroup(), "02").getBalanceHealth(), is(75D));
    }
}