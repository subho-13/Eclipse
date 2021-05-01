package servelet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		final PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.print("</br> Hi <br>");

		final ServletContext ctx = this.getServletContext();
		final String str = ctx.getInitParameter("name");
		out.print(str);
	}
}
