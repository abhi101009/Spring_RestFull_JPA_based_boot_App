package com.aminfo.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aminfo.model.usermanagement.Users;
import com.aminfo.service.UsersService;
import com.aminfo.utils.exceptionHandler.GenericException;

@RestController
@RequestMapping("/user")
public class UsersRestImpl {

	/**
	 * Autowired user service to access service methods
	 */
	@Autowired
	private UsersService usersService;

	/**
	 * Create a new user with an auto-generated id and email and name as passed
	 * values.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public Users create(@RequestParam("emailId") String emailId, @RequestParam("userName") String userName) throws Exception {
		Users user = null;
		try {
			user = new Users(emailId, userName);
			usersService.create(user);
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
		return user;
	}

	/**
	 * Delete the user with the passed id.
	 */
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable long id) throws GenericException {
		try {
			if (id == 92)
				throw new GenericException("custome exception generate to test.");
			
			usersService.delete(id);
		} catch (Exception ex) {
			String errorMsg = "found error while deleting user by id: " + id;
			throw new GenericException(errorMsg);
		}
		return "User succesfully deleted!";
	}

	/**
	 * Retrieve the id for the user with the passed email address.
	 */
	@RequestMapping(value = "/findByEmailId")
	public List<Users> getByEmail(@RequestParam("emailId") String emailId) throws GenericException{
		List<Users> user = null;
		try {
			user = usersService.getByEmail(emailId);
		} catch (Exception ex) {
			throw new GenericException(ex.getMessage());
		}
		return user;
	}

	/**
	 * Update the email and the name for the user identified by the passed id.
	 */
	@RequestMapping(value = "/update/{id}")
	public String updateName(@PathVariable long id, @RequestParam("emailId") String emailId, @RequestParam("userName") String userName) throws GenericException{
		try {
			Users user = usersService.findById(id);
			user.setEmailId(emailId);
			user.setUserName(userName);
			usersService.update(user);
		} catch (Exception ex) {
			throw new GenericException(ex.getMessage());
		}
		return "User succesfully updated!";
	}

	@RequestMapping("/findAll")
	public List<Users> findAll() {
		return usersService.findAll();
	}

	
	@RequestMapping("/findById")
	public Users findById(@RequestParam("id") long id) {
		return usersService.findById(id);
	}

	@RequestMapping("/findByUserName")
	public List<Users> findByUserName(@RequestParam("userName") String userName) {
		System.out.println(userName);
		return usersService.findByUserName(userName);
	}

}