package inn.prec.hibernatemapping.dtos;

public class StudentAreaCount {
	private long count;
	private String area;

	public StudentAreaCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentAreaCount(long count, String area) {
		super();
		this.count = count;
		this.area = area;
	}

	public long getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "StudentAreaCount [count=" + count + ", area=" + area + "]";
	}

}
