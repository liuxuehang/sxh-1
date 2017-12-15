package cn.lxit.books.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.lxit.books.bean.Books;
import cn.lxit.books.dao.BaseDao;
import cn.lxit.books.dao.BooksDao;
import cn.lxit.books.util.Pager;
import cn.lxit.books.bean.Books;

public class BooksDaoImpl extends BaseDao implements BooksDao {

	@Override
	public List<Books> getBooks() {
		List<Books> list = new ArrayList<Books>();
		String sql = "SELECT bid,bookname,b_price,image,stock FROM `Books`";
		Object[] parms = null;
		this.rs = this.executeQuery(sql, parms);
		try {
			while (rs != null && rs.next()) {
				Books b = new Books();
				b.setBid(rs.getInt("bid"));
				b.setBookname(rs.getString("bookname"));
				b.setB_price(rs.getDouble("b_price"));
				b.setImage(rs.getString("image"));
				b.setStock(rs.getInt("stock"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public Books getBookById(int bid) {
		Books books = null;
		String sql = "SELECT bid,bookname,b_price,image,stock FROM `Books` where bid=?";
		Object[] parms = { bid };
		this.rs = this.executeQuery(sql, parms);
		try {
			if (rs != null && rs.next()) {
				books = new Books();
				books.setBid(rs.getInt("bid"));
				books.setBookname(rs.getString("bookname"));
				books.setB_price(rs.getDouble("b_price"));
				books.setImage(rs.getString("image"));
				books.setStock(rs.getInt("stock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return books;
	}

	/*
	 * @Override//按类分页 public Pager<Books> getTopicsGetPageIndex(int bid, int
	 * pageIndex, int pageSize) { Pager<Books> pager = new Pager<>();
	 * pager.setPageIndex(pageIndex); pager.setPageSize(pageSize);
	 * 
	 * pager.setSumCount(this.getSumCount(bid));
	 * 
	 * List<Books> Books = new ArrayList<>(); String sql =
	 * "SELECT  bid,bookname,b_price,image,stock FROM `Books` where 1=1 ";
	 * 
	 * List<Object> list = new ArrayList<>(); if (bid != -1) { sql +=
	 * " and bid=?"; list.add(bid); } sql += " limit ?,?";
	 * list.add((pager.getPageIndex() - 1) * pageSize);
	 * list.add(pager.getPageSize());
	 * 
	 * rs = this.executeQuery(sql, list.toArray()); try { while (rs != null &&
	 * rs.next()) { Books b = new Books(); b.setBid(rs.getInt("bid"));
	 * b.setBookname(rs.getString("bookname"));
	 * b.setB_price(rs.getString("b_price")); b.setStock(rs.getInt("stock"));
	 * b.setImage(rs.getString("image")); Books.add(b); }
	 * 
	 * pager.setData(Books); } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); } finally { this.closeAll(conn, pstmt, rs); } return
	 * pager; }
	 * 
	 * @Override public int getSumCount(int bid) { String sql =
	 * "SELECT count(1) FROM `Books` where 1=1 ";
	 * 
	 * List<Object> list = new ArrayList<>(); if (bid != -1) { sql +=
	 * " and bid=?"; list.add(bid); }
	 * 
	 * try { this.rs = this.executeQuery(sql, list.toArray());
	 * 
	 * if (this.rs.next()) { return rs.getInt(1); } } catch (SQLException e) {
	 * e.printStackTrace(); } finally { this.closeAll(conn, pstmt, rs); } return
	 * 0;
	 * 
	 * }
	 */

	@Override
	public Pager<Books> getTopicsGetPageIndex(int pageIndex, int pageSize) {
		Pager<Books> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);

		// 查询总条数
		page.setSumCount(getSumCount());

		List<Books> list = new ArrayList<Books>();
		Object[] parms = { (page.getPageIndex() - 1) * pageSize, pageSize };
		try {
			String sql = "select bid,bookname,b_price,stock,image FROM `Books` limit ?,?";
			this.rs = this.executeQuery(sql, parms);
			while (rs != null && rs.next()) {
				Books b = new Books();
				b.setBid(rs.getInt("bid"));
				b.setBookname(rs.getString("bookname"));
				b.setB_price(rs.getDouble("b_price"));
				b.setStock(rs.getInt("stock"));
				b.setImage(rs.getString("image"));
				list.add(b);
			}
			page.setData(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return page;
	}

	public int getSumCount() {
		String sql = "SELECT COUNT(1) FROM `Books`";
		this.rs = this.executeQuery(sql, null);
		try {
			if (rs != null && rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return 0;
	}

}
