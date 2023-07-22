package com.deptrai.osahanfood.util;

import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtUtilHelper {
		@Value("${jwt.secret}")
		private String secretKey;
		public String getUsernameFromToken(String token) {
			return getClaimFromToken(token, Claims::getSubject);
		}

		public Date getIssuedAtDateFromToken(String token) {
			
			return getClaimFromToken(token, Claims::getIssuedAt);
		}

		public Date getExpirationDateFromToken(String token) {
			return getClaimFromToken(token, Claims::getExpiration);
		}

		public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
			final Claims claims = getAllClaimsFromToken(token);
			return claimsResolver.apply(claims);
		}

		private Claims getAllClaimsFromToken(String token) {
			return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		}

		private Boolean isTokenExpired(String token) {
			final Date expiration = getExpirationDateFromToken(token);
			return expiration.before(new Date());
		}

		private Boolean ignoreTokenExpiration(String token) {
			// here you specify tokens, for that the expiration is ignored
			return false;
		}

		public String generateToken(String data) {
			SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
			String jwts = Jwts.builder().setSubject(data).signWith(key).compact();
			return jwts;
		}
		public boolean verifyToken(String token) {
			
			try {
				
				  SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
			
				Jws<Claims> jws = Jwts.parserBuilder()
	                    .setSigningKey(key)
	                    .build()
	                    .parseClaimsJws(token);        
				 Claims claims = jws.getBody();
		            String subject = claims.getSubject();
		            // Đọc thêm các thông tin khác nếu cần

		            System.out.println("JWT được xác thực thành công. Subject: " + subject);
			   return true;
			}
			catch (Exception ex) {      // (5)
				 return false;
			    // we *cannot* use the JWT as intended by its creator
			}
		}
		
//
//		private String doGenerateToken(Map<String, Object> claims, String subject) {
//
//			return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//					.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
//		}

		public Boolean canTokenBeRefreshed(String token) {
			return (!isTokenExpired(token) || ignoreTokenExpiration(token));
		}

}
