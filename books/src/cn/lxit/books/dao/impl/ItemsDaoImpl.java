package cn.lxit.books.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.lxit.books.bean.Items;
import cn.lxit.books.bean.Orders;
import cn.lxit.books.dao.BaseDao;
import cn.lxit.books.dao.ItemsDao;

public class ItemsDaoImpl extends BaseDao implements ItemsDao {

	@Override
	public boolean insertItems(Items items) {
		String sql = "INSERT into items (oid,bid,createDate,count,price,total_price)VALUES(?,?,?,?,?,?)";
		Object[] parms = { items.getOid(), items.getBid(), items.getCreateDate(), items.getCount(), items.getPrice(),
				items.getTotal_price() };
		return this.executeUpdate(sql, parms) > 0;
	}

	@Override
	public List<Items> getItems() {
		List<Items> list = new ArrayList<Items>();
		String sql = "SELECT iid,oid,i.bid,createDate,count,price,total_price,images FROM items i INNER JOIN books b ON i.bid=b.bid";
		Object[] parms = { sql, null };
		this.rs = this.executeQuery(sql, parms);
		try {
			if (rs != null && rs.next()) {

				list.add(getItems(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}
    
	@Override
	public List<Items> getItemsById(int oid) {
		List<Items> list = new ArrayList<Items>();
		String sql = "SELECT iid,oid,i.bid,createDate,count,price,total_price,images FROM items i INNER JOIN books b ON i.bid=b.bid WHERE oid=?";
		Object[] parms = { oid };
		this.rs = this.executeQuery(sql, parms);
		try {
			if (this.rs != null && rs.next()) {
				list.add(getItems(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Items> getItemsByName(String userName) {
		List<Items> list = new ArrayList<Items>();
		String sql = "SELECT iid,oid,i.bid,createDate,count,price,total_price,images FROM items i INNER JOIN books b ON i.bid=b.bid INNER JOIN orders o ON i.oid=o.oid WHERE o.username=?";
		Object[] parms = { userName };
		this.rs = this.executeQuery(sql, parms);
		try {
			if (this.rs != null && rs.next()) {
				list.add(getItems(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
		
	}

	public Items getItems(ResultSet rs) {
		Items item = new Items();
		try {
			item.setIid(rs.getInt("iid"));
			item.setOid(rs.getInt("oid"));
			item.setBid(rs.getInt("i.bid"));
			item.setCreateDate(rs.getString("createDate"));
			item.setCount(rs.getInt("count"));
			item.setPrice(rs.getDouble("price"));
			item.setTotal_price(rs.getDouble("total_price"));
			item.setImages(rs.getString("images"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

}
