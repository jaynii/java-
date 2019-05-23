 package cn.database.bao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class datbase {
       public static Connection conn=null;
       public ResultSet r=null;
       
//       public datbase(){  
//       }
	public static Connection getcoConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentSystem","root","");
			System.out.println("连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接失败");
			
		}
		return conn;	
	}
	public static boolean doQueryTeacher(String username, String password) {
		boolean flag=false;
		conn=getcoConnection();
		PreparedStatement psmt=null;
		ResultSet r=null;
		String sql="select count(*) from teachers where username=? and password=?";
		try{
			psmt=(PreparedStatement) conn.prepareStatement(sql);
			psmt.setString(1, username);
			psmt.setString(2, password);
			r=psmt.executeQuery();
			while(r.next()){
				if(r.getInt(1)==1){
					flag=true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	

public static boolean doQueryStudent(String username, String password) {
	boolean flag=false;
	conn=getcoConnection();
	PreparedStatement psmt=null;
	ResultSet r=null;
	String sql="select count(*) from students where username=? and password=?";
	try{
		psmt=(PreparedStatement) conn.prepareStatement(sql);
		psmt.setString(1, username);
		psmt.setString(2, password);
		r=psmt.executeQuery();
		while(r.next()){
			if(r.getInt(1)==1){
				flag=true;
			}
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return flag;
}


public static boolean doRegistTeacher(String username, String password) {
	boolean flag=false;
	conn=getcoConnection();
	PreparedStatement psmt=null;
	ResultSet r=null;
	String sql="insert into RegistTeachers(username,password) values(?,?)";
	try{
		psmt=(PreparedStatement) conn.prepareStatement(sql);
		psmt.setString(1, username);
		psmt.setString(2, password);
		r=psmt.executeQuery();
		while(r.next()){
			if(r.getInt(1)==1){
				flag=true;
			}
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return flag;
}
}