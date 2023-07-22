package com.deptrai.osahanfood.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CustomFilterSecurity {
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Autowired
	CustomJwtFilter customJwtFilter;
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
		AuthenticationManagerBuilder builder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
		builder.userDetailsService(customUserDetailService);
				return builder.build();
		
	}
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails user1 = User.withUsername("user1")
//				.password(passwordEncoder().encode("123"))
//				.roles("USER")
//				.build();
//		UserDetails user2= User.withUsername("user2")
//				.password(passwordEncoder().encode("3456"))
//				.roles("USER")
//				.build();
//		UserDetails admin= User.withUsername("admin")
//				.password(passwordEncoder().encode("1234"))
//				.roles("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(user1,user2,admin);
//	}
	@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	// TODO Auto-generated method stub
		http.cors().disable()
		.csrf().disable().
		sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeHttpRequests()
		.requestMatchers("/login/**")
		.permitAll()
		.anyRequest()
		.authenticated();
		
		http.addFilterBefore(customJwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
