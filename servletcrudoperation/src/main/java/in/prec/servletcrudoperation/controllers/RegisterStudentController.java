package in.prec.servletcrudoperation.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import in.prec.servletcrudoperation.controllers.entities.Address;
import in.prec.servletcrudoperation.controllers.entities.Student;
import in.prec.servletcrudoperation.services.StudentService;
import in.prec.servletcrudoperation.services.StudentServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterStudentController extends HttpServlet {
	private StudentService service = new StudentServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int rollNo=Integer.parseInt(req.getParameter("student_roll_no"));
		String name=req.getParameter("student_name");
		int age=Integer.parseInt(req.getParameter("student_age"));
		String area=req.getParameter("address_area");
		String city=req.getParameter("address_city");
		Student student = new Student();
		Address address = new Address();
		student.setRollNo(rollNo);
		student.setName(name);
		student.setAge(age);
		address.setArea(area);
		address.setCity(city);
		student.setAddress(address);
//		System.out.println(student);
		try {
			req.setAttribute("successMsg", service.add(student));
			RequestDispatcher dispatcher= req.getRequestDispatcher("student/success.jsp");
			dispatcher.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", e.getMessage());
			RequestDispatcher dispatcher= req.getRequestDispatcher("student/error.jsp");
			dispatcher.forward(req, resp);
			
			
		}
	}

}
