package course.springsecurity.implementations.configurations.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Below is custom security configuration
        return httpSecurity
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(EndpointsConstants.getEndpointsWithRequiringAuthentication()).authenticated()
                        .requestMatchers(EndpointsConstants.getEndpointsPostNotRequiringAuthentication()).permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
