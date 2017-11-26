package com.aminfo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.aminfo.model.usermanagement.Users;

@Component
public interface UsersDao extends JpaRepository<Users, Long>  {
	List<Users> getByEmail(String email);
	Users update(Users user);
	List<Users> findByUserName(String userName);
}
