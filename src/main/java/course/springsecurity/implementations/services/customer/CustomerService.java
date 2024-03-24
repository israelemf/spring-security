package course.springsecurity.implementations.services.customer;

import course.springsecurity.implementations.dtos.customer.CreateCustomerDto;

public interface CustomerService {
    void save(CreateCustomerDto createUserDto);
    void deleteById(int id);
}
