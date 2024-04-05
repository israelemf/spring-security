package course.springsecurity.implementations.repositories;

import course.springsecurity.implementations.entities.AccountTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends CrudRepository<AccountTransaction, String> {
    List<AccountTransaction> findByCustomerIdOrderByTransactionDateDesc(int customerId);
}
