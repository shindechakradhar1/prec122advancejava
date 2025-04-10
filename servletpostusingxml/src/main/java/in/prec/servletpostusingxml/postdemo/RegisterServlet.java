package in.prec.servletpostusingxml.postdemo;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	
//	@Override
//	public void doPost(HttpServletRequest request, HttpServletResponse response) {
//		
//	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("student/studentregister.jsp");
//		dispatcher.include(request, response);
		dispatcher.forward(request, response);
	}
}
