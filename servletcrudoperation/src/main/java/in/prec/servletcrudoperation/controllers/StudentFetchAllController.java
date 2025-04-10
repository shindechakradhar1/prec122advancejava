package in.prec.servletcrudoperation.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import in.prec.servletcrudoperation.controllers.entities.Student;
import in.prec.servletcrudoperation.services.StudentService;
import in.prec.servletcrudoperation.services.StudentServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fetchall")
public class StudentFetchAllController extends HttpServlet{
	StudentService service = new StudentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Set<Student> studentList = service.fetchAll();
			req.setAttribute("studentList", studentList);
			RequestDispatcher dispatcher =req.getRequestDispatcher("student/printall.jsp");
			dispatcher.include(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}

}
