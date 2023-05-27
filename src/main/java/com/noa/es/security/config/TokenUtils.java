package com.noa.es.security.config;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


public class TokenUtils {

	private final static String ACCES_TOKEN_SECRET="palabrasecretalagaver4dfret56ytr4er45trw";
	private final static Long ACCES_TOKEN_VALDITY_SECONDS=2_592_000L;
	
	public static String createToken(String user,String rol){
		long expirationTime = ACCES_TOKEN_VALDITY_SECONDS * 10000;
		Date expirationdate = new Date(System.currentTimeMillis()+3600000);
		
		Map<String, Object> extra = new HashMap<>();
		extra.put("user", user);
		
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		
		return Jwts.builder()
				.setSubject(rol)
				.setExpiration(expirationdate)
				.addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
				//.signWith(key)
				.compact();
		
	}
	
	public static UsernamePasswordAuthenticationToken getAthentication(String token) {
		try {

			SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(ACCES_TOKEN_SECRET.getBytes())
					//.setSigningKey(key)
					.build()
					.parseClaimsJws(token)
					.getBody();
			
			String email = claims.getSubject();
			
			return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
		} catch (Exception e) {
			return null;
		}
	}
	
}
