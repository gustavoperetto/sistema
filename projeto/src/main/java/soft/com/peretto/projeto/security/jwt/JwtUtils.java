package soft.com.peretto.projeto.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import soft.com.peretto.projeto.service.UserDetailsImpl;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${projeto.jwtSecret}")
    private String jwtSecret;

    @Value("${projeto.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateTokenFromUserDetailsImpl(UserDetailsImpl userDetail) {
        return Jwts.builder()
                .subject(userDetail.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getSigninKey())
                .compact();
    }

    public Key getSigninKey() {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return key;
    }

    public String getUsernameToken(String token) {
        return Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            System.out.println("Token invalido " + e.getMessage());
            return false;
        } catch (ExpiredJwtException e) {
            System.out.println("Token expirado " + e.getMessage());
            return false;
        } catch (UnsupportedJwtException e) {
            System.out.println("Token não suportado " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Token Argumento invalido " + e.getMessage());
            return false;
        }
    }
}
