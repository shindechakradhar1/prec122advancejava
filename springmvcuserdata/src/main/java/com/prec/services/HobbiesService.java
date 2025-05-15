package com.prec.services;

import java.util.List;

import com.prec.entities.Hobby;

public interface HobbiesService {
	String addHobbies(Hobby hobbies);
	
	List<Hobby> fetchAll();
	
	Hobby fetchHobby(int id);
	
	String updateHobbies(Hobby hobby);
	
	String deleteHobbies(int id);
}
