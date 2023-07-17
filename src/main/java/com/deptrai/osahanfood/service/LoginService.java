package com.deptrai.osahanfood.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deptrai.osahanfood.dto.UserDTO;
import com.deptrai.osahanfood.entity.Roles;
import com.deptrai.osahanfood.entity.Users;
import com.deptrai.osahanfood.payload.request.SignupRequest;
import com.deptrai.osahanfood.repositories.UserRepository;
import com.deptrai.osahanfood.service.imp.LoginServiceImp;
@Service

public class LoginService implements LoginServiceImp {
	
	@Autowired
	UserRepository userRepository;
	@Override
	public List<UserDTO> getAllUsers(){
		List<Users> listUser = userRepository.findAll();
		List<UserDTO> listUserDto = new ArrayList<>();
		for (Users user : listUser) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setCreated_date(user.getCreated_date());
			userDTO.setFullName(user.getFullName());
			userDTO.setUserName(user.getUserName());
			userDTO.setPassword(user.getPassword());
			listUserDto.add(userDTO);
		}
		return listUserDto;
	}
	@Override
	public boolean checkLogin(String username, String password) {
		List<Users> listUsers= userRepository.findByUserNameAndPassword(username, password);
		
		return listUsers.size()>0;
	}
	@Override
	public boolean addUser(SignupRequest signupRequest) {
		Users users = new Users();
		Roles roles = new Roles();
		roles.setId(signupRequest.getRoleId());
		users.setFullName(signupRequest.getFullname());
		users.setUserName(signupRequest.getEmail());
		users.setPassword(signupRequest.getPassword());
		users.setRoles(roles);
		try {
			userRepository.save(users);
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
}
