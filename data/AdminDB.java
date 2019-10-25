package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDB {
public static boolean checkLogin(String adname, String adpw) {
	ConnectionPool cp = ConnectionPool.getInstance();
	Connection conn = cp.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String select = "select * from loginadmin where username = ? and password = ?";
    try {
		pstmt = conn.prepareStatement(select);
		pstmt.setString(1, adname);
		pstmt.setString(2, adpw);
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
}
