package course.springsecurity.implementations.repositories;

import course.springsecurity.implementations.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    Account findByCustomerId(int customerId);
}
