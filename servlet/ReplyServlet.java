package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.Post;
import business.Reply;
import business.ReplyUser;
import data.PostDB;
import data.ReplyDB;

/**
 * Servlet implementation class ReplyServlet
 */
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
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
		String message = "";
		int pid;
		request.setCharacterEncoding("UTF-8");
		
		message = request.getParameter("message");
		pid = Integer.parseInt(request.getParameter("pid"));
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		
		Post post = PostDB.getPostInfo(pid);
		
		ReplyUser replyuser = new ReplyUser();
		Reply reply = new Reply();
		reply.setRtitle(post.getpTitle());
		reply.setRcontent(message);
		reply.setRauthor(username);
		reply.setPid(pid);
		replyuser.setReply(reply);
		
		String msg = "";
		String url = "";
		if(ReplyDB.insert(replyuser)) {
			PostDB.updateReplies(post);
			msg = "Reply successfully added!";
			url = "/viewAllposts";
		}else {
			msg = "There was an error!";
			url = "/newReply.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}


