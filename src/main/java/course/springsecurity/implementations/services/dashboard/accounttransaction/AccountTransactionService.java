package course.springsecurity.implementations.services.dashboard.accounttransaction;

import course.springsecurity.implementations.entities.AccountTransaction;

import java.util.List;

public interface AccountTransactionService {
    List<AccountTransaction> getTransactionsDetails(int id);
}
