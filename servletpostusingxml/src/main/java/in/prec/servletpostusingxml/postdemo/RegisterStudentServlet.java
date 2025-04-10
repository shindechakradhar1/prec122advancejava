package in.prec.servletpostusingxml.postdemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterStudentServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int rollNo=Integer.parseInt(request.getParameter("rollNo"));
		int age=Integer.parseInt(request.getParameter("age"));
		String name=request.getParameter("name");
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		out.print("<h2> Roll No: "+rollNo+"</h2>");
		out.print("<h2> Name: "+name+"</h2>");
		out.print("<h2> Age: "+age+"</h2>");
		
		request.setAttribute("rollNo", rollNo);
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("student/printstudent.jsp");
		dispatcher.forward(request, response);
	}

}
