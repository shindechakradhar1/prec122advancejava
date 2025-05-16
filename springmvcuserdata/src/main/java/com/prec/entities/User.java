package com.prec.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_age")
	private int age;
	@Column(name = "user_gender")
	private String gender;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_address_id")
	private Address address;

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "user_hobby", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "hobby_id"))
	private Set<Hobby> hobbiesSet;

	@ManyToMany(cascade = CascadeType.PERSIST)
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_movie", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movie> movieList;

	public User() {
	}

	public User(String name, int age, String gender, Address address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public User(String name, int age, String gender, Address address, Set<Hobby> hobbiesSet) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.hobbiesSet = hobbiesSet;
	}

	public User(String name, int age, String gender, Address address, List<Movie> movieList) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.movieList = movieList;
	}

	public User(int id, String name, int age, String gender, Address address, Set<Hobby> hobbiesSet,
			List<Movie> movieList) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.hobbiesSet = hobbiesSet;
		this.movieList = movieList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Hobby> getHobbiesSet() {
		return hobbiesSet;
	}

	public void setHobbiesSet(Set<Hobby> hobbiesSet) {
		this.hobbiesSet = hobbiesSet;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", hobbiesSet=" + hobbiesSet + ", movieList=" + movieList + "]";
	}

}
