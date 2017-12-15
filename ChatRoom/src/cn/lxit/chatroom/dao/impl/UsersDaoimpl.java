package cn.lxit.chatroom.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.lxit.chatroom.dao.BaseDao;
import cn.lxit.chatroom.dao.UsersDao;
import cn.lxit.chatroom.entity.Users;

public class UsersDaoimpl extends BaseDao implements UsersDao {

	@Override
	public boolean insert(Users u) {
		String sql="insert into users(u_name,u_pass,u_nickName,u_status,u_addtime) values(?,?,?,0,now())";
		Object[] obj={u.getU_name(),u.getU_pass(),u.getU_nickName()};
		return this.executeUpdate(sql, obj)>0;
	}
	public int selectOne(){
		String sql="select count(1) from users where u_status=1";
		rs=this.executeQuery(sql, null);
		try {
			if(rs.next()){
				int a=rs.getInt("count(1)");
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return 0;
	}
	@Override
	public boolean update( String a) {
		String sql="update users set u_status=1 where u_name=?";
		Object[] obj={a};
		return this.executeUpdate(sql, obj)>0;
	}
	
	@Override
	public boolean updateTwo( String a) {
		String sql="update users set u_status=0 where u_name=?";
		Object[] obj={a};
		return this.executeUpdate(sql, obj)>0;
	}
	@Override
	public String selectName(String name) {
		String sql="select u_name from users where u_name=?";
		Object[] obj={name};
		rs=this.executeQuery(sql, obj);
		try {
			if(rs.next()){
				String userName=rs.getString("u_name");
				return userName;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return null;
	}

	@Override
	public Users select(String UserName, String pwd) {
		String sql="select u_name,u_pass,u_addtime from users where u_name=?and u_pass=?";
		Object[] obj={UserName,pwd};
		rs=this.executeQuery(sql, obj);
		try {
			if(rs.next()){
				Users u=new Users();
				u.setU_name(rs.getString("u_name"));
				u.setU_pass(rs.getString("u_pass"));
				u.setU_addtime(rs.getString("u_addtime"));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return null;
	}

	@Override
	public List<Users> selectAll() {
		List<Users> li=new ArrayList<Users>();
		String sql="select u_name from users where u_status=1";
		rs=this.executeQuery(sql, null);
		try {
			while(rs.next()){
				Users u=new Users();
				u.setU_name(rs.getString("u_name"));
				li.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return li;
	}
	@Override
	public boolean updateOne() {
		String sql="update users set u_status=0";
		return this.executeUpdate(sql, null)>0;
	}

}
