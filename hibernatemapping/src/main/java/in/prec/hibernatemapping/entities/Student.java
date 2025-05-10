package in.prec.hibernatemapping.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
		 @NamedQuery(name="Student.fetchByArea",query = "SELECT s FROM Student s LEFT JOIN FETCH s.address a  where a.addressArea=:area")
		,@NamedQuery(name="Student.fetchByName", query = "SELECT s FROM Student s where s.studentName=:name")
		})


public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private int studentAge;
	private LocalDate studentDob;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_address_id")
	private Address address;
	@ManyToOne(cascade = CascadeType.ALL)
	private Department department;

	public Student() {
	}

	public Student(int studentId, String studentName, int studentAge, LocalDate studentDob, Address address) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentDob = studentDob;
		this.address = address;
	}

	public Student(String studentName, int studentAge, LocalDate studentDob, Address address, Department department) {
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentDob = studentDob;
		this.address = address;
		this.department = department;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public LocalDate getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(LocalDate studentDob) {
		this.studentDob = studentDob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", studentDob=" + studentDob + ", address=" + address + ", department=" + department + "]";
	}

}
