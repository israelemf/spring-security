package course.springsecurity.implementations.configurations.security.providers;

import course.springsecurity.implementations.entities.Authority;
import course.springsecurity.implementations.entities.Customer;
import course.springsecurity.implementations.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsernamePasswordAuthenticationProvider(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String usernameProvided = authentication.getName();
        String passwordProvided = authentication.getCredentials().toString();
        Optional<Customer> customer = customerRepository.findCustomerByEmail(usernameProvided);

        if (customer.isEmpty()) {
            throw new BadCredentialsException("Email não cadastrado!");
        }

        if (passwordEncoder.matches(passwordProvided, customer.get().getPassword())) {
            return new UsernamePasswordAuthenticationToken(usernameProvided, passwordProvided, getGrantedAuthorities(customer.get().getAuthorities()));
        } else {
            throw new BadCredentialsException("Senha inválida!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        authorities
                .forEach(authority -> grantedAuthorities.add(new SimpleGrantedAuthority(authority.getRole())));

        return grantedAuthorities;
    }
}
