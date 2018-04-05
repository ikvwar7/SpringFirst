package mypack.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mypack.dao.AccountDaoMock;
import mypack.domain.Account;

import java.util.List;
import java.util.Objects;

@Component
public class AccountService {

    @Autowired
    private AccountDaoMock accountDaoMock;

    public AccountService() {
    }

    public void printAll() {
        List<Account> accounts = accountDaoMock.getAll();
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }


    public void multiplyAll(Double multiplier) {
        List<Account> accounts = accountDaoMock.getAll();
        accounts.stream().forEach(account -> account.setVolume(account.getVolume() + multiplier / 100.0 * account.getVolume()));
        accountDaoMock.save(accounts);
    }

    public void multiplyOwner(Long ownerId, Double multiplier) {
        List<Account> accounts = accountDaoMock.getAll();
        accounts.stream()
                .filter(account -> Objects.equals(account.getId(), ownerId))
                .forEach(account -> account.setVolume(account.getVolume() + multiplier / 100.0 * account.getVolume()));
        accountDaoMock.save(accounts);
    }


    public void getTotalVolume() {
        List<Account> accounts = accountDaoMock.getAll();
        Double volume = 0.0;
        for (Account acc : accounts) {
            volume += acc.getVolume();
        }
        System.out.println(volume);
    }

    public void getTotalOwnerVolume(Long ownerId) {
        double sum = accountDaoMock.getAll().stream()
                .filter(acc -> Objects.equals(acc.getOwnerId(), ownerId))
                .mapToDouble(Account::getVolume)
                .sum();
        System.out.println(sum);
    }
}

