package cn.lxit.books.util;

import cn.lxit.books.bean.Books;

public class ShoppingItem {

	private Books book;
	private int count;
	private double sumPrice;
	
	public double getItemPrice() {
		sumPrice = book.getB_price() * count;

		return sumPrice;
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
}
