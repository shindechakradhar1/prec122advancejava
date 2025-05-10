package com.prec.controllers.entities;

public class Hobby {
	private String hobbyName;

	public Hobby() {}

	public Hobby(String hobbyName) {
		this.hobbyName = hobbyName;
	}

	public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}

	@Override
	public String toString() {
		return "Hobby [hobbyName=" + hobbyName + "]";
	}

}
