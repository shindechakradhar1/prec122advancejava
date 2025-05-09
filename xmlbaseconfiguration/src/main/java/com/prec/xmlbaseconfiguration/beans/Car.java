package com.prec.xmlbaseconfiguration.beans;

import org.springframework.stereotype.Component;

@Component
public class Car {
	private String model;

	public Car() {}

	public Car(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + "]";
	}

}
