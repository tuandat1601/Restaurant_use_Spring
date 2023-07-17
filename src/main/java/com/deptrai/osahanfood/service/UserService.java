package com.deptrai.osahanfood.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deptrai.osahanfood.dto.UserDTO;
import com.deptrai.osahanfood.entity.Users;
import com.deptrai.osahanfood.repositories.UserRepository;
import com.deptrai.osahanfood.service.imp.UserServiceImp;
@Service
public class UserService  implements UserServiceImp{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<UserDTO> getAllUser() {
		// TODO Auto-generated method stub
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

}
