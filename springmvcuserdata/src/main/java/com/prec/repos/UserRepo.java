package com.prec.repos;

import java.util.List;

import com.prec.entities.User;

public interface UserRepo {
	String addUser(User user);
	List<User> fetchAllUser();
	User fetchUser(int id);
	String updateUser(User user);
	String deleteUser(int id);
}
