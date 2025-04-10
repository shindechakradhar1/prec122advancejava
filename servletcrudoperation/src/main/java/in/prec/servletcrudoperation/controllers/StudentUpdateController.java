package in.prec.servletcrudoperation.controllers;

import java.io.IOException;
import java.sql.SQLException;

import in.prec.servletcrudoperation.controllers.entities.Student;
import in.prec.servletcrudoperation.services.StudentService;
import in.prec.servletcrudoperation.services.StudentServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class StudentUpdateController extends HttpServlet{
	StudentService service = new StudentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			Student student=service.getStudent(id);
			req.setAttribute("student", student);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("student/updatestudent.jsp");
			requestDispatcher.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
