package in.prec.servletjdbcconfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.annotation.Generated;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		final String INSERT_QUERY="INSERT INTO student(name, age) values(?,?)";
		final String SELECT_QUERY="SELECT * FROM student";
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		int rollNo=10;
		String name="Ayush";
		int age=20;
		try {
//			Loading Drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/precdemo","root","root");
				PreparedStatement statement=connection.prepareStatement(SELECT_QUERY);
			){
//			System.out.println("Success");
//			statement.setString(1, name);
//			statement.setInt(2, age);
			ResultSet resultSet=statement.executeQuery();
//			ResultSet resultSet=statement.getGeneratedKeys();
			while(resultSet.next()) {
				writer.print(resultSet.getInt(3)+"</br>");
				writer.print(resultSet.getInt(1)+"</br>");
				writer.print(resultSet.getString(2)+"</br>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}	
