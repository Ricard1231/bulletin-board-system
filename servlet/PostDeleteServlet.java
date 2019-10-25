package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.PostDB;
import data.UserDB;

/**
 * Servlet implementation class PostDeleteServlet
 */
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean delete = false;
		request.setCharacterEncoding("UTF-8");
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		delete = PostDB.delete(pid);
		request.setAttribute("delete", delete);
		
		String msg = "";
		if (delete) {
			msg = "Post with id " + pid + "has been deleted";
		}
		if (delete == false) {
			msg = "Delete error!";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/postmanage");
		rd.forward(request, response);
	}

}
