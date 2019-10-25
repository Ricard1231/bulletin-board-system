package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import data.ConnectionPool;
import data.DBUtil;
import business.User;

public class UserDB {
	public static void insert(User user) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection conn = cp.getConnection();
		PreparedStatement pstmt = null;
		java.sql.Date mySqlDate = new java.sql.Date(user.getDate_of_birth().getTime());
		String query = "insert into users(username, name, email, password, gender, date_of_birth, ulogo) values(?,?,?,?,?,?,?)";
	try {
		pstmt = conn.prepareStatement(query);
		conn.setAutoCommit(false);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getPassword());
		pstmt.setString(5, user.getGender());
		pstmt.setDate(6, mySqlDate);
		pstmt.setString(7, user.getUlogo());
		pstmt.executeUpdate();
		conn.commit();
	} catch (SQLException sqle) {
		sqle.printStackTrace();
		try {
			if (conn != null)
				conn.rollback();
		} catch (SQLException sqle2) {
			sqle2.printStackTrace();
		}
	} finally {
		DBUtil.closePreparedStatement(pstmt);
		cp.freeConnection(conn);
	}
	}
	
	public static boolean usernameExists(String user) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection conn = cp.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String select = "select * from users where username = ?";
		try {
		pstmt = conn.prepareStatement(select);
		pstmt.setString(1, user);
		rs = pstmt.executeQuery();
		return rs.next();
    }catch (SQLException e) {
    	e.printStackTrace();
    	return false;
    }finally {
    	DBUtil.closePreparedStatement(pstmt);
		DBUtil.closeResultSet(rs);
		cp.freeConnection(conn);
    }
	}
	
    public static boolean checkLogin(String username, String password) {
    	ConnectionPool cp = ConnectionPool.getInstance();
    	Connection conn = cp.getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		String select = "select * from users where username = ? and password = ?";
        try {
    		pstmt = conn.prepareStatement(select);
    		pstmt.setString(1, username);
    		pstmt.setString(2, password);
    		rs = pstmt.executeQuery();
    		return rs.next();
        }catch (SQLException e) {
        	e.printStackTrace();
        	return false;
        }finally {
        	DBUtil.closePreparedStatement(pstmt);
    		DBUtil.closeResultSet(rs);
    		cp.freeConnection(conn);
        }
    }
    
    public static User getUserInfo(String username) {
    	User user = new User();
    	ConnectionPool cp = ConnectionPool.getInstance();
    	Connection conn = cp.getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String select = "select * from users where username = ?";
    	try {
    		pstmt = conn.prepareStatement(select);
    		pstmt.setString(1, username);
    		rs = pstmt.executeQuery();
    		if(rs.next()) {
    			user.setUsername(username);
    			user.setGender(rs.getString("gender"));
    			user.setDate_of_birth(rs.getDate("date_of_birth"));
    			user.setUlogo(rs.getString("ulogo"));
    		}
    		return user;
    	}catch (SQLException e) {
        	e.printStackTrace();
        	return null;
        }finally {
        	DBUtil.closePreparedStatement(pstmt);
    		DBUtil.closeResultSet(rs);
    		cp.freeConnection(conn);
    }
}
    
    public static List<User> getUsers(){
    	ConnectionPool cp = ConnectionPool.getInstance();
    	Connection conn = cp.getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	List<User> userslist = new ArrayList<User>();
    	String query = "select * from users";
    	try {
    		pstmt = conn.prepareStatement(query);
    		rs = pstmt.executeQuery();
    		while (rs.next()) {
    			User user = new User();
    			user.setUid(rs.getInt("uid"));
    			user.setUsername(rs.getString("username"));
    			user.setName(rs.getString("name"));
    			user.setEmail(rs.getString("email"));
    			user.setPassword(rs.getString("password"));
    			user.setGender(rs.getString("gender"));
    			user.setDate_of_birth(rs.getTimestamp("date_of_birth"));
    			userslist.add(user);
    		}
    		return userslist;
    	}catch (SQLException e) {
    		e.printStackTrace();
    		return userslist;
    	}finally {
    		DBUtil.closePreparedStatement(pstmt);
    		DBUtil.closeResultSet(rs);
    		cp.freeConnection(conn);	
    	}
    }
    
    public static boolean delete(int uid) {
    	ConnectionPool cp = ConnectionPool.getInstance();
    	Connection conn = cp.getConnection();
    	PreparedStatement pstmt = null;
    	String query = "delete from users where uid = ?";
    	try {
    		pstmt = conn.prepareStatement(query);
    		pstmt.setInt(1, uid);
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


public static void resetPassword(String email, String password) {
	ConnectionPool cp = ConnectionPool.getInstance();
	Connection conn = cp.getConnection();
	PreparedStatement pstmt = null;
	String update = "update users set password=? where email=?";
	try {
		pstmt = conn.prepareStatement(update);
		pstmt.setString(1, password);
		pstmt.setString(2, email);
		pstmt.executeUpdate();
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBUtil.closePreparedStatement(pstmt);
		cp.freeConnection(conn);
	}
}

public static boolean checkEmail(String email) {
	
	ConnectionPool cp = ConnectionPool.getInstance();
	Connection conn = cp.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String select = "select * from users where email = ?";
	
	try {
		pstmt = conn.prepareStatement(select);
		pstmt.setString(1, email);
		rs = pstmt.executeQuery();
		return rs.next();
    }catch (SQLException e) {
    	e.printStackTrace();
    	return false;
    }finally {
    	DBUtil.closePreparedStatement(pstmt);
		DBUtil.closeResultSet(rs);
		cp.freeConnection(conn);
    }
}


public static String getUserlogo(String username) {
	ConnectionPool cp = ConnectionPool.getInstance();
	Connection conn = cp.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = "select ulogo from users where username = ?";
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		return rs.getString("ulogo");
	}catch (SQLException e) {
    	e.printStackTrace();
    	return null;
    }finally {
    	DBUtil.closePreparedStatement(pstmt);
		DBUtil.closeResultSet(rs);
		cp.freeConnection(conn);
}
}
}