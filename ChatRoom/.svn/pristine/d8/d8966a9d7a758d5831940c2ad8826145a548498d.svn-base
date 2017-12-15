package cn.lxit.chatroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BaseDao {
	private final String DriverUrl="com.mysql.jdbc.Driver";
	private final String url="jdbc:mysql://localhost:3306/chatroom";
	private final String UserUrl="root";
	private final String Rwd="root";
	public Connection con=null;
	public PreparedStatement ps=null;
	public ResultSet rs=null;
	public Connection getConnection(){
		try {
			Class.forName(DriverUrl);
			con=DriverManager.getConnection(url, UserUrl, Rwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void closeAll(Connection con,Statement sta,ResultSet rs){
		try {
			if (rs!=null) {
				rs.close();
			}
			if (sta!=null) {
				sta.close();
			}
			if (con!=null) {
				con.close();
			}
			System.out.println("----πÿ±’¡¨Ω”------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int executeUpdate(String sql,Object[] obj){
		con=getConnection();
		try {
			ps=con.prepareStatement(sql);
			if (obj!=null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps, rs);
		}
		return -1;
	}
	public ResultSet executeQuery(String sql,Object[] obj){
		con=getConnection();
		try {
			ps=con.prepareStatement(sql);
			if (obj!=null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			return ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
