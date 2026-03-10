package jjhernan.dev.userauth.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

/**
 * Servicio encargado de gestionar los JSON Web Tokens (JWT).
 *
 * Esta clase se encarga de:
 * - Generar tokens JWT cuando un usuario se autentica correctamente.
 * - Extraer información del token, como el username.
 * - Validar que el token sea correcto y pertenezca al usuario esperado.
 *
 * Los tokens JWT permiten implementar autenticación sin estado (stateless),
 * lo que significa que el servidor no necesita almacenar sesiones.
 */

@Service
public class JwtService {

    private static final String SECRET = "mysecretkeymysecretkeymysecretkey";

    private Key getSignKey(){
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(String username){

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token){

        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, String username){

        String extracted = extractUsername(token);

        return extracted.equals(username);
    }
}