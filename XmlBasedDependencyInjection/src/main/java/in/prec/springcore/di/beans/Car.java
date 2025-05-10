package in.prec.springcore.di.beans;

public class Car {
	private String manufacturer;

	public Car() {}

	public Car(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Car [manufacturer=" + manufacturer + "]";
	}
}
