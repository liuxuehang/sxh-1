package cn.lxit.books.dao.impl;

import java.sql.SQLException;

import cn.lxit.books.dao.BaseDao;
import cn.lxit.books.dao.OrdersDao;

public class OrdersDaoImpl extends BaseDao implements OrdersDao {

	@Override
	public int checkOrders(String userName) {
		String sql = "SELECT oid FROM orders WHERE username=?";
		Object[] parms = { userName };
		this.rs = this.executeQuery(sql, parms);
		try {
			if (rs != null && rs.next()) {
				return rs.getInt("oid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return 0;
	}

	@Override
	public boolean insertOrders(int oid, String userName) {
		String sql = "INSERT INTO orders (oid,username) VALUES(?,?)";
		Object[] parms = { oid, userName };
		return this.executeUpdate(sql, parms) > 0;
	}

}
