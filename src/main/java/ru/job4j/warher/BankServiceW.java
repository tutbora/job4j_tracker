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
            if (find.getGroup().equals(passport)) {
                return find;
            }
        }
        return null;
    }

    public AccountW findByRequisite(String passport, int requisite) {
        UserW rsl = findByPassport(passport);
        if (rsl != null) {
            List<AccountW> accountWS = users.get(rsl);
            for (var userAccount : accountWS) {
                if (userAccount.getReqUnit() == (requisite)) {
                    return userAccount;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, int srcRequisite,
                                 String destPassport, int destRequisite, double amount) {
    var userSrcReq = findByRequisite(srcPassport, srcRequisite);
    var userDestReq = findByRequisite(destPassport, destRequisite);
    if (userSrcReq != null && userDestReq != null) {
        if (userSrcReq.getHealth() >= amount) {
            userSrcReq.setHealth(userSrcReq.getHealth() - amount);
            userDestReq.setHealth(userDestReq.getHealth() + amount);
            return true;
        }
    }
        return false;
    }

    public boolean fight(String srcPassport, int srcRequisite,
                                 String destPassport, int destRequisite) {
        var userSrcReq = findByRequisite(srcPassport, srcRequisite);
        var userDestReq = findByRequisite(destPassport, destRequisite);
        if (userSrcReq != null && userDestReq != null) {
            if (userSrcReq.getHealth() > 0 && userDestReq.getHealth() > 0) {
                userDestReq.setHealth(userDestReq.getHealth() - userSrcReq.getDamage());
                return true;
            }
        }
        return false;
    }
}