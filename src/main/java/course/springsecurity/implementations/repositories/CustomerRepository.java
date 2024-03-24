package course.springsecurity.repositories;

import course.springsecurity.implementations.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
}
