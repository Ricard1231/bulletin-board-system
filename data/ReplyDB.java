package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import data.ConnectionPool;
import data.DBUtil;
import business.Reply;
import business.ReplyUser;

public class ReplyDB {
	public static boolean insert(ReplyUser replyuser){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection conn = cp.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String query = "insert into reply(rtitle, rcontent, rauthor, pid) values(?,?,?,?)";
		String query2 = "update post set pLastAuthor = ? where pid = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, replyuser.getReply().getRtitle());
			pstmt.setString(2, replyuser.getReply().getRcontent());
			pstmt.setString(3, replyuser.getReply().getRauthor());
			pstmt.setInt(4, replyuser.getReply().getPid());
			pstmt.executeUpdate();
			
			pstmt2 = conn.prepareStatement(query2);
			pstmt2.setString(1, replyuser.getReply().getRauthor());
			pstmt2.setInt(2, replyuser.getReply().getPid());
			pstmt2.executeUpdate();
			return true;
		}catch (SQLException e) {
		e.printStackTrace();
		return false;
		}finally {
			DBUtil.closePreparedStatement(pstmt);
			DBUtil.closePreparedStatement(pstmt2);
			cp.freeConnection(conn);
		}
			
		}
	public static List<ReplyUser> viewAllReply(int pid){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection conn = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReplyUser> replylist = new ArrayList<ReplyUser>();
		String query = "select * from reply where pid = ? order by rdate desc";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReplyUser replyuser = new ReplyUser();
				Reply reply = new Reply();
				reply.setRid(rs.getInt("rid"));
				reply.setRtitle(rs.getString("rtitle"));
				reply.setRcontent(rs.getString("rcontent"));
				reply.setRauthor(rs.getString("rauthor"));
				reply.setRdate(rs.getTimestamp("rdate"));
				replyuser.setReply(reply);
				replyuser.setUserlogo(UserDB.getUserlogo(rs.getString("rauthor")));
				replylist.add(replyuser);
			}
			return replylist;
		}catch (SQLException e) {
			e.printStackTrace();
			return replylist;
		} finally {
			DBUtil.closePreparedStatement(pstmt);
			DBUtil.closeResultSet(rs);
			cp.freeConnection(conn);
	}
	
}
	
}