package com.deptrai.osahanfood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deptrai.osahanfood.entity.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	List<Users>findByUserNameAndPassword(String username, String password);
	Users findByUserName(String username);	

}
