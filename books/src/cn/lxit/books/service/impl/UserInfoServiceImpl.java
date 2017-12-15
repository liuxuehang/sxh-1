package cn.lxit.books.service.impl;

import cn.lxit.books.bean.UserInfo;
import cn.lxit.books.dao.UserInfoDao;
import cn.lxit.books.dao.impl.UserInfoDaoImpl;
import cn.lxit.books.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService{
 
	UserInfoDao uid = new UserInfoDaoImpl();
	
	@Override
	public boolean checkuser(UserInfo user) {
		return uid.checkuser(user);  
	}

	@Override
	public boolean insert(UserInfo user) {
		return uid.insert(user);
	}

}
