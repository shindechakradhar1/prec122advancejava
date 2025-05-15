package com.prec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hobby_info")
public class Hobby {
	@Id
	@Column(name = "hobby_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "hobby_name")
	private String hobbyName;

	public Hobby() {
	}

	public Hobby(String hobbyName) {
		this.hobbyName = hobbyName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}

	@Override
	public String toString() {
		return "Hobby [id=" + id + ", hobbyName=" + hobbyName + "]";
	}
}
