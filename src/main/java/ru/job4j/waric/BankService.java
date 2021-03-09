package ru.job4j.waric;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        ArrayList<Account> list = new ArrayList<>();
        users.putIfAbsent(user, list);
    }

    public void addAccount(String passport, Account account) {
        User rsl = findByPassport(passport);
        if (rsl != null) {
            List<Account> list = users.get(rsl);
            if (!list.contains(account)) {
                    list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (var find : users.keySet()) {
            if (find.getPassport().equals(passport)) {
                return find;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User rsl = findByPassport(passport);
        if (rsl != null) {
            List<Account> accounts = users.get(rsl);
            for (var userAccount : accounts) {
                if (userAccount.getRequisite().contains(requisite)) {
                    return userAccount;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
    var userSrcReq = findByRequisite(srcPassport, srcRequisite);
    var userDestReq = findByRequisite(destPassport, destRequisite);
    if (userSrcReq != null && userDestReq != null) {
        if (userSrcReq.getBalance() >= amount) {
            userSrcReq.setBalance(userSrcReq.getBalance() - amount);
            userDestReq.setBalance(userDestReq.getBalance() + amount);
            return true;
        }
    }
        return false;
    }
}