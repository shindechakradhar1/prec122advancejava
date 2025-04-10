package in.prec.servletpostusingxml.postdemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AboutUsServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String aboutUs=req.getParameter("aboutUs");
		long contact=Long.parseLong(req.getParameter("contact"));
		
		PrintWriter writer=resp.getWriter();
		
		writer.print("About Us: " + aboutUs);
		writer.print("contact us: " + contact);
	}
}
