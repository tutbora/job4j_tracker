package ru.job4j.warher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankServiceW {
    private final Map<UserW, List<AccountW>> users = new HashMap<>();

    public void addUser(UserW userW) {
        ArrayList<AccountW> list = new ArrayList<>();
        users.putIfAbsent(userW, list);
    }

    public void addAccount(String passport, AccountW accountW) {
        UserW rsl = findByPassport(passport);
        if (rsl != null) {
            List<AccountW> list = users.get(rsl);
            if (!list.contains(accountW)) {
                    list.add(accountW);
            }
        }
    }

    public UserW findByPassport(String passport) {
        for (var find : users.keySet()) {
            if (find.getPassportGroup().equals(passport)) {
                return find;
            }
        }
        return null;
    }

    public AccountW findByRequisite(String passport, String requisite) {
        UserW rsl = findByPassport(passport);
        if (rsl != null) {
            List<AccountW> accountWS = users.get(rsl);
            for (var userAccount : accountWS) {
                if (userAccount.getRequisiteNUnit().contains(requisite)) {
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
        if (userSrcReq.getBalanceHealth() >= amount) {
            userSrcReq.setBalanceHealth(userSrcReq.getBalanceHealth() - amount);
            userDestReq.setBalanceHealth(userDestReq.getBalanceHealth() + amount);
            return true;
        }
    }
        return false;
    }

    public boolean fight(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite) {
        var userSrcReq = findByRequisite(srcPassport, srcRequisite);
        var userDestReq = findByRequisite(destPassport, destRequisite);
        if (userSrcReq != null && userDestReq != null) {
            if (userSrcReq.getBalanceHealth() > 0 && userDestReq.getBalanceHealth() > 0) {
                userDestReq.setBalanceHealth(userDestReq.getBalanceHealth() - userSrcReq.getDamage());
                return true;
            }
        }
        return false;
    }
}