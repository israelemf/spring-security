package course.springsecurity.implementations.configurations.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Below is custom security configuration
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(EndpointsConstants.getEndpointsWithRequiringAuthentication()).authenticated()
                        .requestMatchers(EndpointsConstants.getEndpointsNotRequiringAuthentication()).permitAll()
                        .requestMatchers(HttpMethod.POST, EndpointsConstants.getEndpointsPostNotRequiringAuthentication()).permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    /*
    @Bean
    public JdbcUserDetailsManager userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

    /*@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("root")
                .authorities("total")
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .authorities("basic")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
