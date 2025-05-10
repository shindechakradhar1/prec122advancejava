package in.prec.hibernatemapping.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="Department.Insert", query = "INSERT INTO department(departmentName) VALUES(:dName)")
})
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentId;
	private String departmentName;
	@OneToMany(mappedBy = "department")
	private Set<Teacher> teacherSet;
	@OneToMany(mappedBy = "department")
	private Set<Student> studentSet;

	public Department() {
	}

	public Department(int departmentId, String departmentName, Set<Teacher> teacherSet) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.teacherSet = teacherSet;
	}

	public Department(String departmentName, Set<Teacher> teacherSet) {
//		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.teacherSet = teacherSet;
	}

	public Department(int departmentId, String departmentName, Set<Teacher> teacherSet, Set<Student> studentSet) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.teacherSet = teacherSet;
		this.studentSet = studentSet;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Teacher> getTeacherSet() {
		return teacherSet;
	}

	public void setTeacherSet(Set<Teacher> teacherSet) {
		this.teacherSet = teacherSet;
	}

	public Set<Student> getStudentSet() {
		return studentSet;
	}

	public void setStudentSet(Set<Student> studentSet) {
		this.studentSet = studentSet;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", teacherSet="
				+ teacherSet + "]";
	}

}
