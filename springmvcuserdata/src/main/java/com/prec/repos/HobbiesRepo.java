package com.prec.repos;

import java.util.List;

import com.prec.entities.Hobby;

public interface HobbiesRepo {
	String addHobbies(Hobby hobby);
	
	List<Hobby> fetchAll();
	
	Hobby fetchHobby(int id);
	
	String updateHobbies(Hobby hobby);
	
	String deleteHobbies(int id);
}
