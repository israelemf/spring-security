package course.springsecurity.implementations.configurations.security;

import course.springsecurity.implementations.repositories.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public CustomerDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Method used by Spring Security to retrieve user details based on the username provided
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var customer = customerRepository.findCustomerByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email não encontrado!"));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customer.getRole()));

        return new User(customer.getEmail(), customer.getPassword(), authorities);
    }
}
