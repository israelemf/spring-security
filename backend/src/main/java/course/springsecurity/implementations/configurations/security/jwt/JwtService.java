package course.springsecurity.implementations.configurations.security.jwt;

import course.springsecurity.implementations.configurations.security.constants.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtService {

    public static String generateToken(Authentication authentication) {
        return generateToken(new HashMap<>(), authentication);
    }

    public static String generateToken(Map<String, Object> extraClaims, Authentication authentication) {
        return Jwts
                .builder()
                .issuer("Liberty Bank")
                .subject(authentication.getName())
                .claims(extraClaims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey())
                .compact();
    }

    public static boolean isTokenValid(String token, Authentication authentication) {
        final String email = extractEmail(token);
        return (email.equals(authentication.getName())) && !isTokenExpired(token);
    }

    private static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private static boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private static String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private static Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /*
     As claims fornecem informações como o ID do usuário, o nome do usuário, o tempo de
     expiração do token e outras informações relevantes. Cada claim é uma afirmação específica sobre o usuário ou a
     entidade relacionada.

     Em um token JWT, as claims são representadas como pares de chave-valor no payload do token. Alguns exemplos comuns
     de claims incluem:

     sub (Subject): Identificador exclusivo para o usuário ou entidade.
     iss (Issuer): Identificador do emissor do token.
     exp (Expiration Time): Tempo em que o token expira e não deve ser aceito para autenticação.
     iat (Issued At): Tempo em que o token foi emitido.
     aud (Audience): Destinatário pretendido do token.
     roles: Declaração sobre as funções (roles) do usuário.

     */
    private static Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    private static SecretKey getSignInKey() {
        return Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
    }
}
