package servlet;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.User;
import data.UserDB;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}

	public static Date convert(String str_date) {
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str_date);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		String username, name, email, password, gender, dobString, ulogo = "";

		request.setCharacterEncoding("UTF-8");

		username = request.getParameter("username");
		name = request.getParameter("name");
		email = request.getParameter("email");
		password = request.getParameter("password");
		gender = request.getParameter("gender");
		dobString = request.getParameter("datepicker").toString();
		ulogo = request.getParameter("ulogo");
		
		
		User user = new User();
		user.setUsername(username);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setGender(gender);
		user.setDate_of_birth(convert(dobString));
		user.setUlogo(ulogo);


		String msg = "";
		String url = "";
		if (UserDB.usernameExists(user.getUsername())) {
			msg = "Username already exist!";
			url = "/reg.jsp";
		} else {
			UserDB.insert(user);
			msg = "Register successful";
			url = "/regOk.jsp";
		}
		request.setAttribute("msg", msg);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
}