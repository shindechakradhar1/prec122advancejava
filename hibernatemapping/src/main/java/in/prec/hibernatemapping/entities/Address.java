package in.prec.hibernatemapping.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String addressArea;
	private String addressCity;
	private int addressZipCode;
	@OneToOne(mappedBy="address")
	private Student student;

	public Address() {}

	public Address(int addressId, String addressArea, String addressCity, int addressZipCode, Student student) {
		this.addressId = addressId;
		this.addressArea = addressArea;
		this.addressCity = addressCity;
		this.addressZipCode = addressZipCode;
		this.student = student;
	}
	public Address(int addressId, String addressArea, String addressCity, int addressZipCode) {
		this.addressId = addressId;
		this.addressArea = addressArea;
		this.addressCity = addressCity;
		this.addressZipCode = addressZipCode;
	}
	public Address(String addressArea, String addressCity, int addressZipCode) {
		this.addressArea = addressArea;
		this.addressCity = addressCity;
		this.addressZipCode = addressZipCode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressArea() {
		return addressArea;
	}

	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public int getAddressZipCode() {
		return addressZipCode;
	}

	public void setAddressZipCode(int addressZipCode) {
		this.addressZipCode = addressZipCode;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressArea=" + addressArea + ", addressCity=" + addressCity
				+ ", addressZipCode=" + addressZipCode + "]";
	}

}
