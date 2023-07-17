package com.deptrai.osahanfood.service.imp;

import java.util.List;

import com.deptrai.osahanfood.dto.UserDTO;
import com.deptrai.osahanfood.payload.request.SignupRequest;

public interface LoginServiceImp {
List<UserDTO> getAllUsers();
boolean checkLogin(String username, String password);
boolean addUser(SignupRequest signupRequest);
}
