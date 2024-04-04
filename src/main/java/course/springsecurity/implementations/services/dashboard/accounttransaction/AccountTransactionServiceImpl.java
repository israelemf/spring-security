package course.springsecurity.implementations.services.dashboard.accounttransaction;

import course.springsecurity.implementations.entities.AccountTransaction;
import course.springsecurity.implementations.repositories.AccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService{
    private final AccountTransactionRepository accountTransactionRepository;

    @Autowired
    public AccountTransactionServiceImpl(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    public List<AccountTransaction> getTransactionsDetails(int id) {
        List<AccountTransaction> accountTransactions = accountTransactionRepository
                .findByCustomerIdOrderByTransactionDateDesc(id);

        if (!accountTransactions.isEmpty()) {
            return accountTransactions;
        } else {
            return null;
        }
    }
}
