package mypack.dao;

import mypack.domain.Account;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class AccountDaoMock implements AccountDao {
    private List<Account> accounts;

    public AccountDaoMock() {
        accounts = new ArrayList<>();
        accounts.add(new Account(1l, "acc1", 1l, 5.0));
        accounts.add(new Account(2l, "acc2", 1l, 10.0));
        accounts.add(new Account(3l, "acc3", 3l, 15.0));
        accounts.add(new Account(4l, "acc4", 4l, 20.0));
        accounts.add(new Account(5l, "acc5", 5l, 30.0));
    }

    public List<Account> getAll() {
        return accounts;
    }

    public Account getById(Long id) {
        return accounts.stream()
                .filter(account -> Objects.equals(account.getId(), id))
                .findFirst()
                .get();
    }

    public List<Account> getByOwner(Long ownerId) {
        return accounts.stream()
                .filter(account -> Objects.equals(account.getOwnerId(), ownerId))
                .collect(Collectors.toList());
    }

    public void save(List<Account> accounts) {
        this.accounts = accounts;
    }
}

