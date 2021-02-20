package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        /*HashSet<Account> rsl = new HashSet<>(accounts);*/
        HashSet<Account> rsl = new HashSet<>();
        /*rsl.addAll(accounts);*/
        for (Account account : accounts) {
            rsl.add(account);
        }
        /*return new HashSet<>(accounts);*/
        return rsl;
    }
}