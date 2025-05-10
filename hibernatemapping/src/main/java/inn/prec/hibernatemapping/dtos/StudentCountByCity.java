package inn.prec.hibernatemapping.dtos;

public class StudentCountByCity {
	private long count;
	private String city;

	public StudentCountByCity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentCountByCity(long count, String city) {
		super();
		this.count = count;
		this.city = city;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "StudentCountByCity [count=" + count + ", city=" + city + "]";
	}

}
