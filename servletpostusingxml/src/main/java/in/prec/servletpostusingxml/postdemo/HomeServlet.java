package in.prec.servletpostusingxml.postdemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int rollNo=Integer.parseInt(req.getParameter("rollNo"));
		String name = req.getParameter("name");
		
		
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		
		writer.print("<h3>Roll No: " + rollNo + "</h3>");
		writer.print("<h3>Name: " + name + "</h3>");
		
	}
}
