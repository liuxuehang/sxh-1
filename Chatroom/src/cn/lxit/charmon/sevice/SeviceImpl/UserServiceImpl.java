package cn.lxit.charmon.sevice.SeviceImpl;

import java.util.List;

import cn.lxit.charmon.ben.Users;
import cn.lxit.charmon.dao.UserDao;
import cn.lxit.charmon.dao.impl.UserDaoImpl;
import cn.lxit.charmon.sevice.UserService;

public class UserServiceImpl implements UserService {
   UserDao userDao=new UserDaoImpl();
	@Override
	public boolean inserUser(Users users) {
		
		return userDao.inserUser(users);
	}

	@Override
	public Users getUserName(String u_name) {
		// TODO Auto-generated method stub
		return userDao.getUserName(u_name);
	}

	@Override
	public Users getLogin(String u_name, String u_pass) {
		// TODO Auto-generated method stub
		return userDao.getLogin(u_name, u_pass);
	}

	@Override
	public boolean getChckstatus(String u_name,int u_status) {
		// TODO Auto-generated method stub
		return userDao.getChckstatus(u_name,u_status);
	}

	@Override
	public List<Users> getUser(int u_status) {
		// TODO Auto-generated method stub
		return userDao.getUser(u_status);
	}

}
