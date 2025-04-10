package in.prec.servletcrudoperation.controllers;

import java.io.IOException;
import java.sql.SQLException;

import in.prec.servletcrudoperation.services.StudentService;
import in.prec.servletcrudoperation.services.StudentServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class StudentDeleteController extends HttpServlet {
	StudentService service = new StudentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		try {
			req.setAttribute("successMsg", service.delete(id));
			RequestDispatcher successDispatcher= req.getRequestDispatcher("student/success.jsp");
			successDispatcher.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", e.getMessage());
			RequestDispatcher deleteDispatcher = req.getRequestDispatcher("student/error.jsp");
			deleteDispatcher.forward(req, resp);
		}
	}
}
