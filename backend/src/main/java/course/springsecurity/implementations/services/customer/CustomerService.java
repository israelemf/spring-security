package course.springsecurity.implementations.services.customer;

import course.springsecurity.implementations.dtos.customer.CreateCustomerDto;
import course.springsecurity.implementations.entities.Customer;
import org.springframework.security.core.Authentication;

public interface CustomerService {
    Customer getCustomerDetails(String email);
    void save(CreateCustomerDto createUserDto);
    void deleteById(int id);
}
