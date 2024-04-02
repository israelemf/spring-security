package course.springsecurity.implementations.services.customer;

import course.springsecurity.implementations.dtos.customer.CreateCustomerDto;
import course.springsecurity.implementations.entities.Customer;
import course.springsecurity.implementations.repositories.CustomerRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(CreateCustomerDto createCustomerDto) {
        var customer = new Customer();
        String email = createCustomerDto.email();
        String passwordHash = passwordEncoder.encode(createCustomerDto.password());

        if (this.customerRepository.findCustomerByEmail(email).isPresent()) {
            throw new EntityExistsException("Esse email já está em uso. Tente outro.");
        }

        BeanUtils.copyProperties(createCustomerDto, customer);
        customer.setPassword(passwordHash);

        this.customerRepository.save(customer);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }
}
