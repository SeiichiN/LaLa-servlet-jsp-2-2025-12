package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Mutter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginUser = (String) request.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>) session.getAttribute("mutterList");
		if (mutterList == null) {
			mutterList = new ArrayList<Mutter>();
			application.setAttribute("mutterList", mutterList);
		}
		String url = "WEB-INF/jsp/main.jsp";
		RequestDispatcher d = request.getRequestDispatcher(url);
		d.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		HttpSession session = request.getSession();
		String loginUser = (String) request.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
		if (mutterList == null) {
			mutterList = new ArrayList<Mutter>();
			application.setAttribute("mutterList", mutterList);
		}
		Mutter mutter = new Mutter(loginUser, text);
		mutterList.add(mutter);
		application.setAttribute("mutterList", mutterList);
		String url = "WEB-INF/jsp/main.jsp";
		RequestDispatcher d = request.getRequestDispatcher(url);
		d.forward(request, response);
	}

}
