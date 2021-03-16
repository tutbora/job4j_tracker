package ru.job4j.warher;

import java.util.*;

public class BattleServiceW {
    private final Map<UserW, List<AccountW>> unitsGroup = new HashMap<>();

    public void addUser(UserW userW) {
        ArrayList<AccountW> list = new ArrayList<>();
        unitsGroup.putIfAbsent(userW, list);
    }

    public void addAccount(String group, AccountW accountW) {
        UserW rsl = findByGroup(group);
        if (rsl != null) {
            List<AccountW> list = unitsGroup.get(rsl);
            if (!list.contains(accountW)) {
                list.add(accountW);
            }
        }
    }

    public UserW findByGroup(String group) {
        for (var find : unitsGroup.keySet()) {
            if (find.getGroup().equals(group)) {
                return find;
            }
        }
        return null;
    }

    public int accountsSize(String group) {
        UserW rsl = findByGroup(group);
        List<AccountW> accountWS = unitsGroup.get(rsl);
        return accountWS.size();
    }

    public AccountW findByParam(String group, int reqUnit) {
        UserW rsl = findByGroup(group);
        if (rsl != null) {
            List<AccountW> accountWS = unitsGroup.get(rsl);
            for (var userAccount : accountWS) {
                if (userAccount.getReqUnit() == (reqUnit)) {
                    return userAccount;
                }
            }
        }
        return null;
    }

    public void fight(String srcGroup, int srcReqUnit,
                      String destGroup, int destReqUnit) {
        var userSrcReq = findByParam(srcGroup, srcReqUnit);
        var userDestReq = findByParam(destGroup, destReqUnit);
        if (userSrcReq != null && userDestReq != null) {
            if (userSrcReq.getHealth() > 0 && userDestReq.getHealth() > 0
                    && userSrcReq.getPriority() > 0 && userDestReq.getPriority() > 0) {
                userDestReq.setHealth(userDestReq.getHealth() - userSrcReq.getDamage());
                if (userDestReq.getHealth() <= 0) {
                    userDestReq.setHealth(0);
                    userDestReq.setPriority(0);
                    /*win(srcGroup, destGroup);*/
                }
            }
        }
    }

    public boolean win(String srcGroup, String destGroup) {
        UserW srcUser = findByGroup(srcGroup);
        UserW destUser = findByGroup(destGroup);
        CreateRound round = new CreateRound();
        if (destUser != null) {
            List<AccountW> accountWS = unitsGroup.get(destUser);
            int i = 0;
            for (AccountW accountW : accountWS) {
                if (accountW.getPriority() > 0) {
                    i += accountW.getPriority();
                }

            }
            if (i == 0) {
                round.win(srcUser.getRace());
                return true;
            }
        }
        return false;
    }
}