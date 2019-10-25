package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Post;
import business.ReplyUser;
import business.User;
import data.PostDB;
import data.ReplyDB;
import data.UserDB;

/**
 * Servlet implementation class PostServlet
 */
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int pid = Integer.parseInt(request.getParameter("pid"));
		Post post = PostDB.viewPost(pid);
		User user = UserDB.getUserInfo(post.getpAuthor());
		List<ReplyUser> replylist = ReplyDB.viewAllReply(pid);
		
		request.setAttribute("post", post);
		request.setAttribute("user", user);
		request.setAttribute("replylist", replylist);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/post.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}

}
