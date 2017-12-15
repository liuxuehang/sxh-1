package cn.lxit.books.dao.impl;

import java.sql.SQLException;

import cn.lxit.books.bean.UserInfo;
import cn.lxit.books.dao.BaseDao;
import cn.lxit.books.dao.UserInfoDao;

public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {

	/**
	 * 判断用户是否存在
	 */
	@Override
	public boolean checkuser(UserInfo user) {
		UserInfo ui = null;
		String sql = "SELECT username,`password` FROM userinfo WHERE username=? AND `password`=?";
		Object[] parms = { user.getUsername(), user.getPassword() };
		this.rs = this.executeQuery(sql, parms);
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return false;
	}

	@Override       
	public boolean insert(UserInfo user) {
		String sql = "INSERT INTO userinfo (username,`password`,email) VALUES(?,?,?)";
		Object[] parms = { user.getUsername(), user.getPassword(), user.getEmail() };
		return this.executeUpdate(sql, parms) > 0;
	}

}
