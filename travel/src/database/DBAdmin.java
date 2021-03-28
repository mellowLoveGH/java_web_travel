package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javabean.Notice;
import javabean.Post;
import javabean.User;

public class DBAdmin {
	
	//
	public static Connection connectDB() {
		Connection con;
		String driver = "com.mysql.jdbc.Driver";
		String database = "travel";
		String url = "jdbc:mysql://localhost:3306/"+ database +"?useSSL=false";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			if(!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("can not connect");
		}
		
		return null;
	}
	
	public static void closeDB(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//
	public static Notice readNotice() {
		
		
		Connection con = connectDB();
		if(con == null) {
			return null;
		}
		String Table_name = "notice";
		
		try {
			Statement statement = con.createStatement();
			String sql = "select * from " + Table_name;
			ResultSet rs = statement.executeQuery(sql);
			
			String attr01 = "topic";
			String attr02 = "scene";
			String attr03 = "activity";
			
			Notice n = new Notice();
			while(rs.next()) {
				String aa = rs.getString(attr01);
				String bb = rs.getString(attr02);
				String cc = rs.getString(attr03);
				
				System.out.println(aa);
				System.out.println(bb);
				System.out.println(cc);

				
				n.setTopic(aa);
				n.setTitle(bb);
				n.setContent(cc);
				
				
			}
			
			rs.close();
			closeDB(con);
			return n;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	//read user from database
	public static List<User> reading() {
		
		List<User> list = new LinkedList<User>();
		
		Connection con = connectDB();
		if(con == null) {
			return null;
		}
		String Table_name = "user";
		
		try {
			Statement statement = con.createStatement();
			String sql = "select * from " + Table_name;
			ResultSet rs = statement.executeQuery(sql);
			
			String attr01 = "name";
			String attr02 = "password";
			
			while(rs.next()) {
				String aa = rs.getString(attr01);
				String bb = rs.getString(attr02);
				
				System.out.println(aa);
				System.out.println(bb);
				
				User user = new User();
				user.setName(aa);
				user.setPassword(bb);
				list.add(user);
			}
			
			rs.close();
			closeDB(con);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	//read posts according to name
	public static List<Post> reading(String name) {
		
		List<Post> list = new LinkedList<Post>();
		
		name = name.trim();
		
		Connection con = connectDB();
		if(con == null) {
			return null;
		}
		String Table_name = "post";
		
		try {
			Statement statement = con.createStatement();
			String sql = "select * from " + Table_name + " where name = '" + name + "'";
			ResultSet rs = statement.executeQuery(sql);
			String attr01 = "id";
			String attr02 = "title";
			String attr03 = "content";
			
			while(rs.next()) {
				int aa = rs.getInt(attr01);
				String bb = rs.getString(attr02).trim();
				String cc = rs.getString(attr03).trim();
				
				System.out.println(aa);
				System.out.println(bb);
				System.out.println(cc);
				
				Post post = new Post();
				post.setName(name);
				post.setId(aa);
				post.setTitle(bb);
				post.setContent(cc);
				
				list.add(post);
			}
			
			rs.close();
			closeDB(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	
	//write into notice
	public static void writeDB(String topic, String scene, String activity) {
		
		Connection con = connectDB();
		if(con == null) {
			return;
		}
		boolean flag = false;
		String Table_name = "notice";
		try {
			
			String sql = "insert into " + Table_name + " values (?,?,?)";
			PreparedStatement preStmt=con.prepareStatement(sql);
			preStmt.setString(1, topic);  
            preStmt.setString(2, scene);
            preStmt.setString(3, activity);
            preStmt.executeUpdate();
			
			closeDB(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	//delete user
	public static void deleteUser(String name) {
		Connection con = connectDB();
		if(con == null) {
			return;
		}
		String Table_name = "user";
		try {
			//
			deleteAllPost(name);
			
			String sql = "delete from " + Table_name + " where name='" + name + "'";
			PreparedStatement preStmt=con.prepareStatement(sql);
            preStmt.executeUpdate();
			
			closeDB(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//delete one post
	public static void deletePost(String name, int id) {
		
		Connection con = connectDB();
		if(con == null) {
			return;
		}
		String Table_name = "post";
		try {
			
			String sql = "delete from " + Table_name + " where name='" + name + "' and id=" + id;
			PreparedStatement preStmt=con.prepareStatement(sql);
            preStmt.executeUpdate();
			
			closeDB(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//
	public static void deleteAllPost(String name) {
		
		Connection con = connectDB();
		if(con == null) {
			return;
		}
		String Table_name = "post";
		try {
			
			String sql = "delete from " + Table_name + " where name='" + name + "'";
			PreparedStatement preStmt=con.prepareStatement(sql);
            preStmt.executeUpdate();
			
			closeDB(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void main(String[] args) {
//		reading();
//		String qn = "What is your name";
//		System.out.println(qn);
		
//		reading();
//		reading("aaa");
		
//		writeDB("canada", "gentle", "riding");
//		deletePost("aaa", 1);
//		deleteAllPost("aaa");
//		deleteUser("ccc");
		System.out.println(readNotice());
		
	}
	
	
}
