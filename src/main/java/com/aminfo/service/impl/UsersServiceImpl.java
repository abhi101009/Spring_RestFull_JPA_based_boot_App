package com.aminfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aminfo.dao.UsersDao;
import com.aminfo.model.usermanagement.Users;
import com.aminfo.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDao usersDao;

	@Override
	public Users create(Users user) {
		return usersDao.save(user);
	}

	@Override
	public void delete(Long id) {
		usersDao.delete(id);
	}

	@Override
	public List<Users> getByEmail(String email) {
		List<Users> users = usersDao.getByEmail(email);
		return users;
	}

	@Override
	public Users update(Users user) {
		return usersDao.update(user);
	}

	@Override
	public List<Users> findAll() {
		return usersDao.findAll();
	}

	@Override
	public Users findById(long id) {
		return usersDao.findOne(id);
	}

	@Override
	public List<Users> findByUserName(String userName) {
		return usersDao.findByUserName(userName);
	}
}
