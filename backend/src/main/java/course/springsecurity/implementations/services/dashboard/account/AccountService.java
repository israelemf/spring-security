package course.springsecurity.implementations.services.dashboard.account;

import course.springsecurity.implementations.entities.Account;

public interface AccountService {
    Account getAccountDetails(int id);
}
