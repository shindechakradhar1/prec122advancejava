package in.prec.servletcrudoperation.repos;

import java.sql.SQLException;
import java.util.Set;

import in.prec.servletcrudoperation.controllers.entities.Student;

public interface StudentRepo {
	String add(Student student) throws ClassNotFoundException, SQLException;
	
	Set<Student> fetchAll() throws ClassNotFoundException, SQLException;
	
	String delete(int id) throws ClassNotFoundException, SQLException;
	Student getStudent(int id) throws ClassNotFoundException, SQLException;
	String update(Student student) throws ClassNotFoundException, SQLException;
}
