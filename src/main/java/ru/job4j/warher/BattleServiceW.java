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

    public static int randomRace(int actions) {
        int rsl = 1;
        Random rand = new Random();
        if (actions == 1) {
            rsl = rand.nextInt(actions + 1) + 1;
        }
        if (actions == 2) {
            rsl = rand.nextInt(actions) + 3;
        }
        return rsl;
    }

    public static int[] randomUnit(int actions) {
        LinkedHashSet<Integer> forArray = new LinkedHashSet<>();
        Random random = new Random();
        int[] rsl = new int[actions];
        int ii = 0;
        do {
            forArray.add(random.nextInt(actions) + 1);
        }
        while (forArray.size() != actions);
        for (var i : forArray) {
            rsl[ii] = i;
            ii++;
        }
        return rsl;
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

    public boolean transferMoney(String srcGroup, int srcReqUnit,
                                 String destGroup, int destReqUnit, double amount) {
    var userSrcReq = findByParam(srcGroup, srcReqUnit);
    var userDestReq = findByParam(destGroup, destReqUnit);
    if (userSrcReq != null && userDestReq != null) {
        if (userSrcReq.getHealth() >= amount) {
            userSrcReq.setHealth(userSrcReq.getHealth() - amount);
            userDestReq.setHealth(userDestReq.getHealth() + amount);
            return true;
        }
    }
        return false;
    }

    public boolean fight(String srcGroup, int srcReqUnit,
                         String destGroup, int destReqUnit) {
        var userSrcReq = findByParam(srcGroup, srcReqUnit);
        var userDestReq = findByParam(destGroup, destReqUnit);
        UserW rsl1 = findByGroup(srcGroup);
        UserW rsl2 = findByGroup(destGroup);
        List<AccountW> accountWS1 = unitsGroup.get(rsl1);
        List<AccountW> accountWS2 = unitsGroup.get(rsl2);
        CreateRound round = new CreateRound();
        if (userSrcReq != null && userDestReq != null) {
            if (userSrcReq.getHealth() > 0 && userDestReq.getHealth() > 0) {
                userDestReq.setHealth(userDestReq.getHealth() - userSrcReq.getDamage());
                if (userDestReq.getHealth() <= 0) {
                    deleteAccount(destGroup, userDestReq.getReqUnit());
                }
                //return true;
            }
        }
        if (accountWS1.size() == 0) {
            round.win(2);
        }
        if (accountWS2.size() == 0) {
            round.win(1);
        }
        return true;
    }

    public boolean deleteAccount(String group, int reqUnit) {
        UserW rsl = findByGroup(group);
        if (rsl != null) {
            List<AccountW> accountWS = unitsGroup.get(rsl);
            for (var userAccount : accountWS) {
                if (userAccount.getHealth() <= 0) {
                    accountWS.remove(reqUnit - 1);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteAccountTest(String group, int reqUnit) {
        UserW rsl = findByGroup(group);
        if (rsl != null) {
            List<AccountW> accountWS = unitsGroup.get(rsl);
            accountWS.remove(reqUnit - 1);
            return true;
        }
        return false;
    }
}