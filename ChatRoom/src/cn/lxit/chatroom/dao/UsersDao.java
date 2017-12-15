package cn.lxit.chatroom.dao;

import java.util.List;

import cn.lxit.chatroom.entity.Users;

public interface UsersDao {
	boolean insert(Users u);//用户注册
	boolean update(String a);
	boolean updateOne();
	boolean updateTwo(String a);
	int selectOne();
	Users select(String UserName,String pwd);//用户登录
	String selectName(String name);
	List<Users> selectAll();
}
