package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	public String findUsername(String username) {
		String psw = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/travel?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String user = "root";
			String password = "1234";
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			String sql = "select * from user where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs == null) {
				return null;
			}
			if (rs.next()) {
				psw = rs.getString("password");
			} else {
				psw = null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return psw;
	}

	public void addUser(String username, String psw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/travel?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String user = "root";
			String password = "1234";// ��Ϊ�Լ����û�����������ݿ���
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO user VALUES(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, psw);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

//	public static void main(String[] args) {
//		String psw = new User().findUsername("qw");
//		System.out.println(psw);
//		User u = new User();
//		u.addUser("345", "345");
//	}

}