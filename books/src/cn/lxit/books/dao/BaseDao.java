package cn.lxit.books.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BaseDao {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;

	/*private final String driverUrl = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/NewsManagerSystem";
	private final String userName = "root";
	private final String pwd = "root";*/

	// 获取连接对象
	public Connection getConnection() {
		/*try {
			Class.forName(driverUrl);
			conn = DriverManager.getConnection(url, userName, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		ComboPooledDataSource cd = new ComboPooledDataSource();
		try {
			conn =  cd.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 关闭连接对象
	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();  
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 实现对数据库的增，删，改操作,返回受影响的行数
	public int executeUpdate(String sql, Object[] parms) {
		try {
			// 获取连接
			conn = getConnection();
			// 获取执行对象
			pstmt = conn.prepareStatement(sql);
			// 给执行对象中的sql语句赋参数
			if (parms != null) {
				for (int i = 0; i < parms.length; i++) {
					pstmt.setObject(1 + i, parms[i]);
				}
			}
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return -1;
	}

	// 实现查询的方法 注意： 一定不能在此方法后面加上关闭,返回结果集
	public ResultSet executeQuery(String sql, Object[] parms) {
		try {
			// 获取连接
			conn = getConnection();
			// 获取执行对象
			pstmt = conn.prepareStatement(sql);
			// 给执行对象中的sql语句赋参数
			if (parms != null) {
				for (int i = 0; i < parms.length; i++) {
					pstmt.setObject(1 + i, parms[i]);
				}
			}
			return pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
