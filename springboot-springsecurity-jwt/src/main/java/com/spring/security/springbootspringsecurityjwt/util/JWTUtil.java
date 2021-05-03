package com.spring.security.springbootspringsecurityjwt.util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class JWTUtil {
	
	private final String SECRET_KEY="Secret";
	
	Logger logger=LoggerFactory.getLogger(JWTUtil.class);
	
	public String extractUsername(String token)
	{
		logger.info("local logs Method start JWTUtil->extractUsername()");
		return extractClaim(token, Claims::getSubject);
	}

	public String extractExpiration(String token)
	{
		logger.info("local logs Method start JWTUtil->extractExpiration()");
		return extractClaim(token, Claims::getSubject);
	}
	
	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		logger.info("local logs Method start JWTUtil->extractClaim()");
		final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		logger.info("local logs Method start JWTUtil->extractAllClaims()");
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		logger.info("local logs Method start JWTUtil->isTokenExpired()");
		return extractClaim(token, Claims::getExpiration).before(new Date());
	}
	
	public String generateToken(UserDetails userDetails)
	{
		logger.info("local logs Method start JWTUtil->generateToken()");
		Map<String,Object> claims=new HashMap<>();
		return createToken(claims,userDetails.getUsername());
	}

	 private String createToken(Map<String, Object> claims, String username) {
		 logger.info("local logs Method start JWTUtil->createToken()");
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		logger.info("local logs Method start JWTUtil->validateToken()");
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
