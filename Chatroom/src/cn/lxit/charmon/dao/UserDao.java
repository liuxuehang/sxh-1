package cn.lxit.charmon.dao;

import java.util.List;

import cn.lxit.charmon.ben.Users;

public interface UserDao {
	/**
	 * 判断用户名是否存在
	 * @param u_name
	 * @return
	 */
  Users getUserName(String u_name);
  /**
   * 增加用户
   * @param users
   * @return
   */
 public	boolean inserUser(Users users);
 /**
  * 判断用户名与密码
  * @param u_name
  * @param u_pass
  * @return
  */
  Users getLogin(String u_name,String u_pass);
  /**
   * 判断状态
   * @param user
   * @return
   */
 boolean getChckstatus(String u_name,int u_status);
   /**
    * 在线用户
    * @param u_status
    * @return
    */
   List<Users> getUser(int u_status);
}
