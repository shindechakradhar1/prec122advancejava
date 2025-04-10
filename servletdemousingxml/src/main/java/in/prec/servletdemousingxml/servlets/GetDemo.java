package in.prec.servletdemousingxml.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetDemo extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("doGetMethod");
		int id= Integer.parseInt(req.getParameter("id"));
		String name= req.getParameter("name");
		
		System.out.println(id);
		System.out.println(name);
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		writer.write("<h3>"+id+"</h3>");
		writer.write("<h3>"+name+"</h3>");
	}
}
