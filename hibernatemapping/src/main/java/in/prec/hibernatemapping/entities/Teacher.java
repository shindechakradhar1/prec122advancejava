package in.prec.hibernatemapping.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	private String teacherName;
	private LocalDate teacherJoinigDate;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teacher_subject", joinColumns = @JoinColumn(name = "teacherId"), inverseJoinColumns = @JoinColumn(name = "subjectId"))
	private List<Subject> subjectList;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "teacher_department", joinColumns = @JoinColumn(name = "teacherId"), inverseJoinColumns = @JoinColumn(name = "departmentId"))
	private Department department;

	public Teacher() {
	}

	public Teacher(String teacherName, LocalDate teacherJoinigDate, List<Subject> subjectList, Department department) {
		this.teacherName = teacherName;
		this.teacherJoinigDate = teacherJoinigDate;
		this.subjectList = subjectList;
		this.department = department;
	}

	public Teacher(int teacherId, String teacherName, LocalDate teacherJoinigDate) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherJoinigDate = teacherJoinigDate;
	}

	public Teacher(String teacherName, LocalDate teacherJoinigDate) {
		this.teacherName = teacherName;
		this.teacherJoinigDate = teacherJoinigDate;
	}

	public Teacher(String teacherName, LocalDate teacherJoinigDate, List<Subject> subjectList) {
		this.teacherName = teacherName;
		this.teacherJoinigDate = teacherJoinigDate;
		this.subjectList = subjectList;
	}
	public Teacher(String teacherName, LocalDate teacherJoinigDate, Department department) {
		this.teacherName = teacherName;
		this.teacherJoinigDate = teacherJoinigDate;
		this.department=department;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public LocalDate getTeacherJoinigDate() {
		return teacherJoinigDate;
	}

	public void setTeacherJoinigDate(LocalDate teacherJoinigDate) {
		this.teacherJoinigDate = teacherJoinigDate;
	}

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherJoinigDate="
				+ teacherJoinigDate + ", subjectList=" + subjectList + "]";
	}

}
