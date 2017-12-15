package cn.lxit.charmon.sevice;

import java.util.List;

import cn.lxit.charmon.ben.Users;

public interface UserService {
	public	boolean inserUser(Users users);
	  Users getUserName(String u_name);
	  Users getLogin(String u_name,String u_pass);
	  boolean getChckstatus(String u_name,int u_status);
	  List<Users> getUser(int u_status);
}
