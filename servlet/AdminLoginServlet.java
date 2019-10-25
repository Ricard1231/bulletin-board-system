package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.AdminDB;
import data.UserDB;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username, password ="";
		request.setCharacterEncoding("UTF-8");
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		String msg="";
		String url="";
		if(AdminDB.checkLogin(username, password)) {
			url = "/adminindex.jsp";
			msg = "Login successful!";
			session.setAttribute("user", username);
	}else {
		url = "/adminlogin.jsp";
		msg = "Username or password is wrong, please try again";
		request.setAttribute("head", msg);
	}
	RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
	rd.forward(request, response);

}
}