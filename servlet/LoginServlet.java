package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.UserDB;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username, password ="";
		int limit;
		request.setCharacterEncoding("UTF-8");
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		limit = Integer.parseInt(request.getParameter("limit"));
		
		Cookie c = new Cookie("username", username);
		c.setMaxAge(limit * 24 * 60 * 60);
		response.addCookie(c);
		HttpSession session = request.getSession();
		
		String msg="";
		String url="";
		if(UserDB.checkLogin(username, password)) {
			url = "/viewAllposts";
			msg = "Login successful!";
			session.setAttribute("user", username);
			ServletContext application = this.getServletContext();
			ArrayList<String> visitors = (ArrayList<String>)application.getAttribute("namelist");
			if (visitors == null) {
				visitors = new ArrayList<String>();
				application.setAttribute("namelist", visitors);
			}
			boolean unique = true;
			for(int i = 0; i < visitors.size(); i++) {
				if (visitors.get(i).equals(username)) {
					unique = false;
					break;
				}
			}
			if (unique)
				visitors.add(username);
		}else {
			url = "/login.jsp";
			msg = "Username or password is wrong, please try again";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}