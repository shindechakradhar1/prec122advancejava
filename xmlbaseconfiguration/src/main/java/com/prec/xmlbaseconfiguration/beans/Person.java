package com.prec.xmlbaseconfiguration.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name;
	private int age;
	
	@Autowired
	private Car car;
	public Person(Car car) {
		this.car=car;
	}

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, Car car) {
		this.name = name;
		this.age = age;
		this.car = car;
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

	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
	}

}
