package cn.lxit.charmon.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.lxit.charmon.ben.Users;
import cn.lxit.charmon.dao.BaseDao;
import cn.lxit.charmon.dao.UserDao;


public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public boolean inserUser(Users users) {
		String sql="INSERT INTO users (u_name,u_pass,u_nickName)VALUES(?,?,?)";
		Object[] parms={users.getU_name(),users.getU_pass(),users.getU_nickName()};
		return this.executeUpdate(sql, parms)>0;
	}

	@Override
	public Users getUserName(String name) {
		Users user=null;
		String sql="SELECT * FROM users WHERE u_name=?";
		Object[] parms={name};
		try {
			this.rs=this.executeQuery(sql, parms);
			if(this.rs.next()){
				user=getUserModel(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return user;
	}
	
	private  Users getUserModel(ResultSet rs){
		Users use=new Users();
		try {
			use.setU_name(rs.getString("u_name"));
			use.setU_pass(rs.getString("u_pass"));
			use.setU_nickName(rs.getString("u_nickName"));
			use.setU_status(rs.getInt("u_status"));
			use.setU_addtime(rs.getString("u_addtime"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return use;
	}

	@Override
	public Users getLogin(String u_name, String u_pass) {
		Users user=null;
		String sql="SELECT *FROM users WHERE u_name=? AND u_pass=?";
		Object[] parms={u_name,u_pass};
		try {
			this.rs=this.executeQuery(sql, parms);
			if(rs!=null&&this.rs.next()){
				user=getUserModel(rs);
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return null;
	}
   
	
	@Override
	public List<Users> getUser(int u_status) {
	   List<Users> list=new ArrayList();
	   String sql="SELECT * FROM users WHERE u_status=?";
	   Object[] parms={u_status};
	   try {
		this.rs=this.executeQuery(sql, parms);
		   while(this.rs.next()){
			   Users user=getUserModel(rs);
			   list.add(user);
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		this.closeAll(conn, pstmt, rs);
	}
		return list;
	}

	@Override
	public boolean getChckstatus(String u_name,int u_status) {
		String sql="UPDATE users SET  u_status=? WHERE u_name=? ";
		Object[] parms={u_status,u_name};
		return this.executeUpdate(sql, parms)>0;
	}

	

}
