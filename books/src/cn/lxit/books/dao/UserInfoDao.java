package cn.lxit.books.dao;

import cn.lxit.books.bean.UserInfo;

public interface UserInfoDao {

	 /**
	  * 判断用户是否存在
	  * @param user
	  * @return
	  */
	 public boolean checkuser(UserInfo user);
	 
	 boolean insert(UserInfo user);
}
