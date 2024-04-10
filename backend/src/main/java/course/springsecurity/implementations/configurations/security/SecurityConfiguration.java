package course.springsecurity.implementations.configurations.security;

import course.springsecurity.implementations.configurations.security.filters.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Below is custom security configuration
        return httpSecurity
                .securityContext(securityContext -> securityContext
                        .requireExplicitSave(false))
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .cors(corsCustomizer -> corsCustomizer
                        .configurationSource(corsConfigurationSource()))
                .csrf(csrfCustomizer -> csrfCustomizer
                        .csrfTokenRequestHandler(csrfTokenRequestAttributeHandler())
                        .ignoringRequestMatchers(EndpointsConstants.getEndpointsRequestNotRequiringAuthentication())
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(EndpointsConstants.getEndpointsWithRequiringAuthentication()).authenticated()
                        .requestMatchers(EndpointsConstants.getEndpointsGetNotRequiringAuthentication()).permitAll()
                        .requestMatchers(HttpMethod.GET, EndpointsConstants.getEndpointsGetRequiringAuthentication()).authenticated()
                        .requestMatchers(HttpMethod.POST, EndpointsConstants.getEndpointsRequestNotRequiringAuthentication()).permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler() {
        CsrfTokenRequestAttributeHandler requestHandler =  new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        return requestHandler;
    }

    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
        corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return source;
    }
}
