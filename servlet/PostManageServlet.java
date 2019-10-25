package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Post;
import business.User;
import data.PostDB;
import data.UserDB;

/**
 * Servlet implementation class PostManageServlet
 */
public class PostManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		List<Post> postslist = PostDB.viewAll();
		request.setAttribute("postslist", postslist);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/postmanage.jsp");
		rd.forward(request, response);
		
	}

}
