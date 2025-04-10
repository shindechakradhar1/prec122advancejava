package in.prec.servletcrudoperation.services;

import java.sql.SQLException;
import java.util.Set;

import in.prec.servletcrudoperation.controllers.entities.Student;
import in.prec.servletcrudoperation.repos.StudentRepo;
import in.prec.servletcrudoperation.repos.StudentRepoImpl;

public class StudentServiceImpl implements StudentService{

	private StudentRepo repo = new StudentRepoImpl();
	
	@Override
	public String add(Student student) throws ClassNotFoundException, SQLException {
		return repo.add(student);
	}

	@Override
	public Set<Student> fetchAll() throws ClassNotFoundException, SQLException {
		return repo.fetchAll();
	}
	
	public String delete(int id) throws ClassNotFoundException, SQLException {
		return repo.delete(id);
	}
	
	public Student getStudent(int id) throws ClassNotFoundException, SQLException {
		return repo.getStudent(id);
	}

	@Override
	public String update(Student student) throws ClassNotFoundException, SQLException {
		return repo.update(student);
	}
	
	

}
