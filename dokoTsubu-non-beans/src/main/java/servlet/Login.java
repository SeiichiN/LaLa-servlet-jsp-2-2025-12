package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		boolean isLogin = false;
		if (pass.equals("1234")) { isLogin = true; }

		if (isLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", name);
		}
		String url = "WEB-INF/jsp/loginResult.jsp";
		RequestDispatcher d =
				request.getRequestDispatcher(url);
		d.forward(request, response);
	}

}
