package com.restfulapi.co.config.jwt;

/*import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;*/
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {

    private static final String SECRET_KEY = "7B3A9E24F5D8C1672A4F8790E5CB218E4A137BBE81F463A21C6C8430FDE92B7A";

    public String extractUsuario(String jwToken) {
        return null;
    }

    /*private Claims extractAllClaims(String jwToken){ //deprecatedWay
        return Jwts
                .parser()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(jwToken)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }*/

}
