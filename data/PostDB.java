package data;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import business.Post;

public class PostDB {
	public static List<Post> viewAll(){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection conn = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Post> postslist = new ArrayList<Post>();
		String query = "select * from post order by pLastUpdate desc";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Post post = new Post();
				post.setPid(rs.getInt("pid"));
				post.setpTitle(rs.getString("ptitle"));
				post.setpDate(rs.getTimestamp("pdate"));
				post.setpAuthor(rs.getString("pauthor"));
				post.setpReplies(rs.getInt("preplies"));
				post.setpClicks(rs.getInt("pclicks"));
				post.setpLastUpdate(rs.getString("pLastUpdate"));
				post.setpLastAuthor(rs.getString("pLastAuthor"));
				postslist.add(post);
			}
			return postslist;
		} catch (SQLException e) {
		e.printStackTrace();
		return postslist;
	} finally {
		DBUtil.closePreparedStatement(pstmt);
		DBUtil.closeResultSet(rs);
		cp.freeConnection(conn);
	}
}
	public static Post viewPost(int pid) {
		Post post = new Post();
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection conn = cp.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		String query = "select * from post where pid = ?";
		String sql = "update post set pclicks = ? where pid = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				post.setPid(rs.getInt("pid"));
				post.setpTitle(rs.getString("ptitle"));
				post.setpContent(rs.getString("pcontent"));
				post.setpDate(rs.getTimestamp("pdate"));
				post.setpAuthor(rs.getString("pauthor"));
				post.setpReplies(rs.getInt("preplies"));
				post.setpClicks(rs.getInt("pclicks") + 1);
				post.setpLastUpdate(rs.getString("pLastUpdate"));
				post.setpLastAuthor(rs.getString("pLastAuthor"));
			
				pstmt2 = conn.prepareStatement(sql);
				pstmt2.setInt(1, post.getpClicks());
				pstmt2.setInt(2, pid);
				pstmt2.executeUpdate();
				return post;
			}else {
				return null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closePreparedStatement(pstmt);
			DBUtil.closePreparedStatement(pstmt2);
			DBUtil.closeResultSet(rs);
			cp.freeConnection(conn);
		}
	}
	
	public static Post getPostInfo(int pid) {
		Post post = new Post();
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection conn = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from post where pid = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				post.setPid(rs.getInt("pid"));
				post.setpTitle(rs.getString("ptitle"));
				post.setpContent(rs.getString("pcontent"));
				post.setpDate(rs.getTimestamp("pdate"));
				post.setpAuthor(rs.getString("pauthor"));
				post.setpReplies(rs.getInt("preplies"));
				post.setpClicks(rs.getInt("pclicks"));
				post.setpLastUpdate(rs.getString("pLastUpdate"));
				post.setpLastAuthor(rs.getString("pLastAuthor"));
				return post;
			}else {
				return null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closePreparedStatement(pstmt);
			DBUtil.closeResultSet(rs);
			cp.freeConnection(conn);
		}
	}
	
	public static boolean insert(Post post) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection conn = cp.getConnection();
		PreparedStatement pstmt = null;
		String query = "insert into post(ptitle, pcontent, pauthor) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, post.getpTitle());
			pstmt.setString(2, post.getpContent());
			pstmt.setString(3, post.getpAuthor());
			pstmt.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			DBUtil.closePreparedStatement(pstmt);
			cp.freeConnection(conn);
		}
	}
	
	public static int get_pid(Post post) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection conn = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select pid from post where ptitle = ? and pcontent = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, post.getpTitle());
			pstmt.setString(2, post.getpContent());
			rs = pstmt.executeQuery();
			return rs.getInt("pid");
		} catch (SQLException e) {
		e.printStackTrace();
		return 0;
		} finally {
			DBUtil.closePreparedStatement(pstmt);
			DBUtil.closeResultSet(rs);
			cp.freeConnection(conn);
		}
	}
	
	public static void updateReplies(Post post) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection conn = cp.getConnection();
		PreparedStatement pstmt = null;
		String query = "update post set preplies = ? where pid = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (post.getpReplies() + 1));
			pstmt.setInt(2, post.getPid());
			pstmt.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.closePreparedStatement(pstmt);
			cp.freeConnection(conn);
		}
	}
	
	public static boolean delete(int pid) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection conn = cp.getConnection();
		PreparedStatement pstmt = null;
		String query = "delete from post where pid = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pid);
			pstmt.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DBUtil.closePreparedStatement(pstmt);
		cp.freeConnection(conn);
		}
	}
}
