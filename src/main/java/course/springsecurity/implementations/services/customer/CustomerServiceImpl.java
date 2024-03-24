package course.springsecurity.implementations.services.customer;

import course.springsecurity.implementations.dtos.customer.CreateCustomerDto;
import course.springsecurity.implementations.entities.Customer;
import course.springsecurity.implementations.repositories.CustomerRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(CreateCustomerDto createCustomerDto) {
        String email = createCustomerDto.email();

        if (this.customerRepository.findByEmail(email).isPresent()) {
            throw new EntityExistsException("Esse email já está em uso. Tente outro.");
        }

        var customer = new Customer();
        BeanUtils.copyProperties(createCustomerDto, customer);

        this.customerRepository.save(customer);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }
}
