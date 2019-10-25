package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.User;
import data.UserDB;

/**
 * Servlet implementation class ForgotPassServlet
 */
public class ForgotPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String newpass = request.getParameter("newpass");
		String renewpass = request.getParameter("renewpass");
		String chEmail = request.getParameter("chEmail");
		
		HttpSession session = request.getSession();
		
		if(newpass.equals(null) || newpass =="" || renewpass.equals(null) || renewpass=="" || chEmail.equals(null) || chEmail =="") 
		{
			request.setAttribute("msg", "Please fill in all required fields!");
			getServletContext().getRequestDispatcher("/forgotPass.jsp").forward(request, response);
		}
		else if(!newpass.equals(renewpass))
		{
			request.setAttribute("msg", "Password does not match!");
			getServletContext().getRequestDispatcher("/forgotPass.jsp").forward(request, response);
		}
		else {
			User user = new User();
				user.setPassword(newpass);
				user.setEmail(chEmail);
				
				String msg="";
				String url="";
				if(UserDB.checkEmail(chEmail)) {
					UserDB.resetPassword(chEmail, newpass);
					url = "/login.jsp";
					msg = "Password Updated Successfully!";
				}else {
					url = "/forgotPass.jsp";
					msg = "Password Not Updated, Try again later!";
				}
				request.setAttribute(msg, "msg");
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
				return;
			
			
			/*String sql = "update users set password=? where username=?";
			int i = UserDB.resetPassword(user,sql);
			
			if(i!=0)
			{
				request.setAttribute("msg", "Password Updated Successfully!");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "Password Not Updated, Try again later!");
				getServletContext().getRequestDispatcher("/forgotPass.jsp").forward(request, response);
			}*/
		}
	}

}
