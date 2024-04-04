package course.springsecurity.implementations.repositories;

import course.springsecurity.implementations.entities.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {
    List<Loan> findByCustomerIdOrderByStartDateDesc(int customerId);
}
