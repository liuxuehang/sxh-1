package cn.lxit.charmon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BaseDao {
 public  Connection conn=null;
 public  ResultSet rs=null;
 public  PreparedStatement pstmt=null;
 
 ComboPooledDataSource  ds=new ComboPooledDataSource();
 /**
  * 获取连接对象
  * @return
  */
 public Connection getConnection(){
	 try {
		conn=ds.getConnection();
		 System.out.println(conn);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 return conn;
 }
 /**
  * 关闭资源
  * @param conn
  * @param stmt
  * @param rs
  */
 public void closeAll(Connection conn,Statement stmt,ResultSet rs){
	 try {
		if(rs!=null)
			 rs.close();
		 if(stmt!=null)
			 stmt.close();
		 if(conn!=null)
			 conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
 /**
  * 实现增删改
  * @param sql
  * @param parms
  * @return
  */
 public int executeUpdate(String sql, Object[] parms) {
	 try {
		conn=getConnection();
		 pstmt=conn.prepareStatement(sql);
		 if(parms!=null){
			 for(int i=0;i<parms.length;i++){
				 pstmt.setObject(i+1, parms[i]);
			 }
		 }
		 return pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		this.closeAll(conn, pstmt, rs);
	}
	 return -1;
 }
 /**
  * 查询
  * @param sql
  * @param parms
  * @return
  */
 public ResultSet executeQuery(String sql,Object[] parms){
	 try {
		conn=getConnection();
		 pstmt=conn.prepareStatement(sql);
		 if(parms!=null){
			 for(int i=0;i<parms.length;i++){
				 pstmt.setObject(i+1, parms[i]);
			 }
		 }
		 return pstmt.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return null;
 }
 
}
