package cn.lxit.chatroom.service.impl;

import java.util.List;

import cn.lxit.chatroom.dao.UsersDao;
import cn.lxit.chatroom.dao.impl.UsersDaoimpl;
import cn.lxit.chatroom.entity.Users;
import cn.lxit.chatroom.service.UsersServiceDao;

public class UsersServiceDaoimpl implements UsersServiceDao {
	UsersDao ud=new UsersDaoimpl();
	@Override
	public boolean insert(Users u) {
		return ud.insert(u);
	}
	public int selectOne(){
		return ud.selectOne();
	}
	@Override
	public boolean update(String a) {
		
		return ud.update(a);
	}
	
	@Override
	public boolean updateTwo(String a) {
		
		return ud.updateTwo(a);
	}
	@Override
	public Users select(String name,String pwd) {
		
		return ud.select(name, pwd);
	}

	@Override
	public String selectName(String name) {
		
		return ud.selectName(name);
	}

	@Override
	public List<Users> selectAll() {
		
		return ud.selectAll();
	}
	@Override
	public boolean updateOne() {
		
		return ud.updateOne();
	}

}
