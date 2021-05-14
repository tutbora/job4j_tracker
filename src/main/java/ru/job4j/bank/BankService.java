package ru.job4j.bank;

import java.util.*;
/**
 * @author Z.Ruslan
 * @version 1.0
 * Class for service accounts of clients
 */
public class BankService {
    /**
     * This object contain database users with unique passports, accounts, requisites
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Method create a new user in library bank if did not find this client
     * @param user accept user name
     */
    public void addUser(User user) {
        ArrayList<Account> list = new ArrayList<>();
        users.putIfAbsent(user, list);
    }

    /**
     * Method create new account for user if did not find account which accepted
     * @param passport unique passport
     * @param account account in database
     */
    public void addAccount(String passport, Account account) {
        User rsl = findByPassport(passport);
        if (rsl != null) {
            List<Account> list = users.get(rsl);
            if (!list.contains(account)) {
                    list.add(account);
            }
        }
    }

    /**
     * Method find unique user passport in database
     * @param passport unique passport
     * @return user if found his passport
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Method return user account if found user passport and account requisite
     * @param passport unique passport
     * @param requisite user account
     * @return user account
     */
    public Account findByRequisite(String passport, String requisite) {
        User rsl = findByPassport(passport);
        if (rsl == null) {
            return null;
        }
        return users.get(rsl)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null);
    }

    /**
     * Method for money transfer from 1 account requisite to
     * 2 (this or other) account requisite and return true if this operation is true
     * @param srcPassport unique user passport number 1
     * @param srcRequisite user account requisite number 1
     * @param destPassport unique user passport number 2
     * @param destRequisite user account requisite number 2
     * @param amount sum for money transfer
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                              String destPassport, String destRequisite, double amount) {
    var userSrcReq = findByRequisite(srcPassport, srcRequisite);
    var userDestReq = findByRequisite(destPassport, destRequisite);
    if (
            userSrcReq != null
            && userDestReq != null
            && userSrcReq.getBalance()
            >= amount) {

            userSrcReq.setBalance(userSrcReq.getBalance() - amount);
            userDestReq.setBalance(userDestReq.getBalance() + amount);
            return true;
    }
    return false;
    }
}