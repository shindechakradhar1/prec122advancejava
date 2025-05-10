package com.prec.xmlbaseconfiguration.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.prec.xmlbaseconfiguration.beans.Car;
import com.prec.xmlbaseconfiguration.beans.Person;

@Configuration
public class AppConfig {
	
	@Bean("porche")
	public Car getCar() {
		Car car = new Car();
		car.setModel("Porche");
		return car;
	}
	@Bean("tesla")
	@Primary
	public Car getCar1() {
		Car car = new Car();
		car.setModel("Test");
		return car;
	}
	
	@Bean
	public Person getPerson() {
		Person person = new Person();
		person.setName("Sakshi");
		person.setAge(20);
		person.setCar(getCar1());
		
		return person;
	}

}
