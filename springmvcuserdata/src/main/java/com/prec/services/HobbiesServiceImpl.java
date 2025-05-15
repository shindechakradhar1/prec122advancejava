package com.prec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prec.entities.Hobby;
import com.prec.repos.HobbiesRepo;

@Service
public class HobbiesServiceImpl implements HobbiesService{

	
	@Autowired
	private HobbiesRepo repo;
	
	@Override
	public String addHobbies(Hobby hobby) {
		return repo.addHobbies(hobby);
	}

	@Override
	public List<Hobby> fetchAll() {
		return repo.fetchAll();
	}

	@Override
	public Hobby fetchHobby(int id) {
		return repo.fetchHobby(id);
	}

	@Override
	public String updateHobbies(Hobby hobby) {
		return repo.updateHobbies(hobby);
	}

	@Override
	public String deleteHobbies(int id) {
		return repo.deleteHobbies(id);
	}
	
	
	
}
