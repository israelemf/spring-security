package course.springsecurity.implementations.configurations.security.filters;

import course.springsecurity.implementations.configurations.security.constants.SecurityConstants;
import course.springsecurity.implementations.configurations.security.jwt.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenGenerateFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", authentication.getName());
            String jwtToken = JwtService.generateToken(claims, authentication);

            response.setHeader(SecurityConstants.JWT_HEADER, jwtToken);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath().equals("/user");
    }

}
