package com.prec.services;

import java.util.List;

import com.prec.entities.User;

public interface UserService {
	String addUser(User user);
	
	List<User> fetchAllUser();
	
	User fetchUser(int id);
	
	String updateUser(User user);
	
	String deleteUser(int id);
}
