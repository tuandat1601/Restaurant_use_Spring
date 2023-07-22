package com.deptrai.osahanfood.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.deptrai.osahanfood.util.JwtUtilHelper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class CustomJwtFilter extends OncePerRequestFilter {
@Autowired
JwtUtilHelper jwtUtilHelper;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getTokenFromHeader(request);
		
		if (token != null) {
			
			if(jwtUtilHelper.verifyToken(token)) {
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("","",new ArrayList<>());
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authenticationToken);
			}
			else {
				System.out.println("Fillter jwt false");
			}
		}
	
		filterChain.doFilter(request, response);
		
	}
	private String getTokenFromHeader(HttpServletRequest request) {
		String requestHeader = request.getHeader("Authorization");
		String token = null;
		if (StringUtils.hasText(requestHeader)&&requestHeader.startsWith("Bearer ")) {
			token = requestHeader.substring(7);
		}
		return token;
	}
	

}
