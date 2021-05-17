package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUserWithoutDoublet() {
        User user = new User("3434", "Petr Arsentev");
        Optional<User> userExpect = Optional.of(user);
        User user2 = new User("1111", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(userExpect.get());
        bank.addUser(user2);
        bank.addUser(userExpect.get());
        assertThat(bank.findByPassport("3434"), is(userExpect));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "5546"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
//        assertThat(bank.findByRequisite("3434", "5546").orElseThrow().getBalance(), is(150D));
//        assertThat(Objects.requireNonNull(
//        bank.findByRequisite("3434", "5546").orElse(null)).getBalance(), is(150D));

    }

    @Test
    public void add2Accounts() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("1111", 300D));
        bank.addAccount(user.getPassport(), new Account("2222", 150D));
        var checkBalanceOne = bank.findByRequisite("3434", "1111").get().getBalance();
        var checkBalanceTwo = bank.findByRequisite("3434", "2222").get().getBalance();
        assertThat(checkBalanceOne, is(300D));
        assertThat(checkBalanceTwo, is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
    }

    @Test
    public void transferMoneyTrue() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        var transfer = bank.transferMoney(
                user.getPassport(),
                "5546", user.getPassport(),
                "113", 150D);
        assertThat(transfer, is(true));
    }

    @Test
    public void doesNotTransferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        var checkTransfer = bank.transferMoney(
                user.getPassport(),
                "5546", user.getPassport(),
                "113", 200D);
        var checkBalance = bank.findByRequisite(user.getPassport(), "5546").get().getBalance();
        assertThat(checkBalance, is(150D));
        assertThat(checkTransfer, is(false));
    }
}