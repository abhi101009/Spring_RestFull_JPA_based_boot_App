package com.aminfo.service;

import java.util.List;

import com.aminfo.model.usermanagement.Users;

public interface UsersService {

	Users create(Users user);
	void delete(Long id);
	Users update(Users user);
	List<Users> findAll();
	Users findById(long id);
	List<Users> findByUserName(String userName);
	List<Users> getByEmail(String email);
}
