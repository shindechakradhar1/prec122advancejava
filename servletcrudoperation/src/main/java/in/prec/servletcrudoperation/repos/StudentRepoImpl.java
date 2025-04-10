package in.prec.servletcrudoperation.repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import in.prec.servletcrudoperation.controllers.entities.Address;
import in.prec.servletcrudoperation.controllers.entities.Student;

public class StudentRepoImpl implements StudentRepo {

	@Override
	public String add(Student student) throws ClassNotFoundException, SQLException {
		String msg = "";
		int addressId = 0;
		final String INSERT_ADDRESS = "INSERT INTO address(area, city) VALUES(?,?)";
		final String INSERT_STUDENT = "INSERT INTO student(roll_no, name, age, address_id) values(?,?,?, ?)";
		Connection connection = getConnection();
		try (PreparedStatement statement = connection.prepareStatement(INSERT_ADDRESS,
				Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, student.getAddress().getArea());
			statement.setString(2, student.getAddress().getCity());
			if (statement.executeUpdate() > 0) {
				ResultSet resultSet = statement.getGeneratedKeys();
				while (resultSet.next())
					addressId = resultSet.getInt(1);
				try (PreparedStatement pStatement = connection.prepareStatement(INSERT_STUDENT);) 
				{
					pStatement.setInt(1, student.getRollNo());
					pStatement.setString(2, student.getName());
					pStatement.setInt(3, student.getAge());
					pStatement.setInt(4, addressId);
					if (pStatement.executeUpdate() > 0)
						msg = "Record Inserted Successfully..";
					else
						msg = "Error While Inserting Student Record..";
				}
			} else
				msg = "Error While Inserting Address Record..";
		}
		return msg;
	}

	@Override
	public Set<Student> fetchAll() throws ClassNotFoundException, SQLException {
		Set<Student> sortedSet = new TreeSet<>((s1,s2)->s1.getRollNo()-s2.getRollNo());
		final String SELECT_ALL_STUDENT="SELECT student.id, roll_no,  name, age, address_id, address.id, area, city "
				+ "FROM student JOIN address ON address_id=address.id";
		try(
				Connection connection=getConnection();
				PreparedStatement pStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
			){
			
			ResultSet resultSet=pStatement.executeQuery();
			while(resultSet.next())
				sortedSet.add(new Student(
						resultSet.getInt(1),
						resultSet.getInt(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						new Address(
						resultSet.getInt(6),
						resultSet.getString(7),
						resultSet.getString(8)
						)));
		}
		
		
		
		return sortedSet;
	}
	
	public String delete(int id) throws ClassNotFoundException, SQLException {
		final String DELETE_STUDENT="DELETE FROM student WHERE id=?";
		final String DELETE_ADDRESS="DELETE FROM address WHERE address.id=?";
		String msg="";
		int addressId=0;
		
		try(
				PreparedStatement selectStatement = getConnection().prepareStatement("SELECT address_id from Student where id=?");
			){
			selectStatement.setInt(1, id);
			ResultSet executeQuery = selectStatement.executeQuery();
			if(executeQuery.next())
				addressId=executeQuery.getInt(1);
		}
		try(
				Connection connection=getConnection();
				PreparedStatement statement=connection.prepareStatement(DELETE_STUDENT);
			){
			statement.setInt(1, id);
			if(statement.executeUpdate()>0)
				try(
						PreparedStatement statement1=connection.prepareStatement(DELETE_ADDRESS);
						
					){
					statement1.setInt(1, addressId);
					if(statement1.executeUpdate()>0) {
						msg="Record Deleted Successfully..";
					}else
						msg="Error Occured while Removing Address Record";
					
				}else {
					msg="Error Occured while Removing Student Record";
				}
			return msg;
		}
		
		
	}
	@Override
	public String update(Student student) throws ClassNotFoundException, SQLException {
		String msg="";
		final String UPDATE_STUDENT="UPDATE student JOIN address ON address_id=address.id"
				+" set " 
				+ "roll_no=? ,"
				+ "name=? ,"
				+ "age=? ,"
				+ "area=? ,"
				+ "city=? "
				+ "where student.id=?";
		
		System.out.println(UPDATE_STUDENT);
		try(
				Connection connection=getConnection();
				PreparedStatement updateStatement=connection.prepareStatement(UPDATE_STUDENT);
			){
			updateStatement.setInt(1, student.getRollNo());
			updateStatement.setString(2, student.getName());
			updateStatement.setInt(3, student.getAge());
			updateStatement.setString(4, student.getAddress().getArea());
			updateStatement.setString(5, student.getAddress().getCity());
			updateStatement.setInt(6, student.getId());
			
			if(updateStatement.executeUpdate()>0) 
				msg="Record Updated Successfully..";
			else
				msg="Problem Occured while Updating Record..";
		}
		return msg;
	}
	
	
	public Student getStudent(int id) throws ClassNotFoundException, SQLException {
		Student student=null;
		try(
				PreparedStatement selectStatement= getConnection().prepareStatement("SELECT * FROM student JOIN address ON address_id=address.id WHERE student.id=?");
			){
			selectStatement.setInt(1, id);
			ResultSet studentSet=selectStatement.executeQuery();
			if(studentSet.next()) {
				
				student=new Student(
				studentSet.getInt(1),
				studentSet.getInt(2),
				studentSet.getString(3),
				studentSet.getInt(4),
				new Address(0, studentSet.getString(7),
				studentSet.getString(8))
				);
			}
				
		}
		return student;
	}
	
	

	private Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/preccrud", "root", "root");

	}

}
