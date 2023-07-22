package com.deptrai.osahanfood.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deptrai.osahanfood.dto.UserDTO;
import com.deptrai.osahanfood.entity.Users;
import com.deptrai.osahanfood.payload.ResponseData;
import com.deptrai.osahanfood.payload.request.SignupRequest;
import com.deptrai.osahanfood.repositories.UserRepository;
import com.deptrai.osahanfood.service.LoginService;
import com.deptrai.osahanfood.service.imp.LoginServiceImp;
import com.deptrai.osahanfood.util.JwtUtilHelper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {


@Autowired
LoginServiceImp loginServiceImp;

@Autowired
JwtUtilHelper jwtUtilHelper;
@PostMapping("/signin")
public ResponseEntity<?> signin(@RequestParam String username,@RequestParam String password){
	ResponseData responseData = new ResponseData();
	

	

	if(loginServiceImp.checkLogin(username, password)) {
		String token = jwtUtilHelper.generateToken(username) ;
		
		responseData.setSuccess(true);
		responseData.setData(token);
	}
	else {
		responseData.setSuccess(false);
	}
	return new ResponseEntity<>(responseData,HttpStatus.OK);
}
@PostMapping("/signup")
public ResponseEntity<?>signup(@RequestBody SignupRequest signupRequest){
	ResponseData responseData = new ResponseData();
	
		responseData.setData(loginServiceImp.addUser(signupRequest));
	
	return new ResponseEntity<>(responseData,HttpStatus.OK);
}
//@GetMapping("")
//public ResponseEntity<?>getAllUser(){
//	ResponseData responseData = new ResponseData();
//	
//	responseData.setData(loginServiceImp.getAllUsers());
//	return new ResponseEntity<>(responseData,HttpStatus.OK);
//}
}
