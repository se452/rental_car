//package com.CarRental.user.utils;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.security.Signature;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Component
//public class JWTUtil {
//
//    public String extractUserName(String token){
//        return extractUserName(token, Claims::getSubject);
//    }
//
//    public String generatetoken(UserDetails userDetails){
//        return extractUserName(new HashMap<>(), userDetails);
//    }
//
//    public boolean isTokenValid(String token, UserDetails userDetails){
//        final String userName = extractUserName(token);
//        return (userName.equals(userDetails.getUsername())) && !isTokenValid(token);
//    }
//
//    private  <T> T extractClaim(String Toke, Function<Claims, T> claimsResolvers){
//        final Claims claims = extractAllClaims(token);
//        return claimsResolvers.apply(claims);
//    }
//
//    private String generateToken(Map<String, Object> extraClaims, userDetails userDetails){
//        return  Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()) + 1000 * 60 * 24)
//                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
//    }
//
//    private String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails){
//        return  Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()) + 604800000)
//                .signWith(getSigningKey(), SignatureAlgorith.HS256).compact();
//    }
//
//    private  boolean isTokenExpired(String token){
//        return extractExpiration(token).before(new Date());
//    }
//
//    private  Date extractExpiration(String token){
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    private Claims extractAllClaims(String token){
//        return Jwts.parserBuilder().getSigningKey(getSigningKey)).build().parseClaimsJws(token)
//                .getBody();
//    }
//
//    private Key getSigningKey(){
//        byte[] keyBytes = Decoders.BASE64.decode("");
//                return Keys.hmacShaKey(keyBytes);
//    }
//
//
//
//
//}


package com.carRental.user.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTUtil {

    // Extract the username from the token
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Generate token using UserDetails
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    // Validate the token
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    // Extract a specific claim from the token
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Generate token with extra claims
    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // 24 hours
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Generate a refresh token with a different expiration time
    private String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 604800000)) // 7 days
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Check if the token is expired
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extract the expiration date from the token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Extract all claims from the token
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Get the signing key used for signing the JWTs
    private Key getSigningKey() {
        String secret = "YzFldWxwdWJiY29kaWNuZXFpcWxhNXU2NDdvcXI1MmR5eW0wbXhoYmg1eWJ4dTFxYXgwcGI2MjVqeWk4N3lsMnNqd2RoampwbXR3NWk1ZXcydW13bGVkcjBsYnZ4d3B2bXl3bTVqM2xvZDU4bWFreTI5dGc5OGRoMWJsYXFycXY="; // to replace with sec key
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

