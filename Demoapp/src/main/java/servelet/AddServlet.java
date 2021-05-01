package servelet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		final int i = Integer.parseInt(req.getParameter("num1"));
		final int j = Integer.parseInt(req.getParameter("num2"));

		final int k = i + j;

		final Cookie cookie = new Cookie("k", k + "");
		res.addCookie(cookie);
//		final HttpSession session = req.getSession();
//		session.setAttribute("k", k);

//		final RequestDispatcher rd = req.getRequestDispatcher("sq");
//		rd.forward(req, res);
		res.sendRedirect("sq");
	}
}
