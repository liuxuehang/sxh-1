package cn.lxit.chatroom.service;


import java.util.List;

import cn.lxit.chatroom.entity.Users;

public interface UsersServiceDao {
	boolean insert(Users u);
	boolean update(String a);
	boolean updateOne();
	boolean updateTwo(String a);
	int selectOne();
	Users select(String UserName,String pwd);
	String selectName(String name);
	List<Users> selectAll();
}
