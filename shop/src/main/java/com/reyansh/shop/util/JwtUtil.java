package com.reyansh.shop.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtil {
    private static final String SECRET_KEY = "eRfzYJzPxM8CjDhXZcVeHszAj"
                    + "Md4mSIZ23ujUyPkpegDTJ2dDAAmFaJdIUQq";

    private Claims extractAllClaims(String token) {
        final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Date extractExpiration(String token) {
        return this.extractClaim(token, Claims::getExpiration);
    }

    public String extractUsername(String token) {
        return this.extractClaim(token, Claims::getSubject);
    }

    public String generateToken(String username) {
        final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder().setSubject(username)
                        .setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
                        .signWith(key, SignatureAlgorithm.HS256).compact();
    }

    public boolean isTokenExpired(String token) {
        return this.extractExpiration(token).before(new Date());
    }

    public boolean validateToken(String token, String username) {
        return this.extractUsername(token).equals(username) && !this.isTokenExpired(token);
    }
}
