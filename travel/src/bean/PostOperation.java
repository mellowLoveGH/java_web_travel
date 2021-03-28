package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javabean.Post;

public class PostOperation {
	public void addPost(Post p) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String db = "travel";
			String url = "jdbc:mysql://localhost:3306/" + db + "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String user = "root";
			String password = "1234";// 改为自己的用户名密码和数据库名
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			//
			String sql = "INSERT INTO post VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getId());
			pstmt.setString(3, p.getTitle());
			pstmt.setString(4, p.getContent());

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
	public ArrayList<Post> findAll() {
		ArrayList<Post> list = new ArrayList<Post>();
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
			String sql = "select * from post";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				Post p = new Post();
				p.setName(rs.getString("name"));
				p.setId(rs.getInt("id"));
				p.setTitle(rs.getString("title"));
				p.setContent(rs.getString("content"));			
				list.add(p);
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
		return list;
	}
	
	public void deletePsot(String username,int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/travel?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String user = "root";
			String password = "1234";
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			String sql = "delete from user where name=? and id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setInt(2, id);
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
}

