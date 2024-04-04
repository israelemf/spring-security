package course.springsecurity.implementations.services.dashboard.account;

import course.springsecurity.implementations.entities.Account;
import course.springsecurity.implementations.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccountDetails(int id) {
        return accountRepository.findByCustomerId(id);
    }
}
