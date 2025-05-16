package com.prec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prec.entities.User;
import com.prec.repos.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public String addUser(User user) {
		return userRepo.addUser(user);
	}

	@Override
	public List<User> fetchAllUser() {
		return userRepo.fetchAllUser();
	}

	@Override
	public User fetchUser(int id) {
		return userRepo.fetchUser(id);
	}

	@Override
	public String updateUser(User user) {
		return userRepo.updateUser(user);
	}

	@Override
	public String deleteUser(int id) {
		return userRepo.deleteUser(id);
	}

}
