package com.deptrai.osahanfood.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deptrai.osahanfood.entity.Users;
import com.deptrai.osahanfood.repositories.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService {
@Autowired
UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.print("username"+username);
		Users users = userRepository.findByUserName(username);
		if (users ==null) {
			throw new UsernameNotFoundException("User can't found");
		}
		return new User(username,users.getPassword(),new ArrayList<>());
	}

}
