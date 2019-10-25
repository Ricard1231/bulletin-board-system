package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.Post;
import data.PostDB;

/**
 * Servlet implementation class NewPostServlet
 */
public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String title, message = "";
		request.setCharacterEncoding("UTF-8");
		
		title = request.getParameter("title");
		message = request.getParameter("message");
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		
		Post post = new Post();
		post.setpTitle(title);
		post.setpContent(message);
		post.setpAuthor(username);
		
		String msg = "";
		String url = "";
		if(PostDB.insert(post)) {
			msg = "Post successfully added!";
			url = "/viewAllposts";
		}else {
			msg = "There was an error, please try again!";
			url = "/newPost.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
		/*String title, message = "";
		request.setCharacterEncoding("UTF-8");
		
		title = request.getParameter("title");
		message = request.getParameter("message");
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		
		Post post = new Post();
		post.setpTitle(title);
		post.setpContent(message);
		post.setpAuthor(username);
		
		String msg = "";
		String url = "";
		try {
			PostDB.insert(post);
			msg = "Post successfully added!";
			url = "/post.jsp";
		}catch (Exception e) {
			msg = "There was an error, please try again!";
			url = "/newPost.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}*/
