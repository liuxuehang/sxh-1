package cn.lxit.books.service;

import java.util.ArrayList;
import java.util.List;

import cn.lxit.books.bean.Books;
import cn.lxit.books.bean.ShoppingItem;

/**
 * 购物车的抽象类
 * 
 * @author Administrator
 *
 */
public abstract class ShoppingItemService {

	private List<ShoppingItem> items = new ArrayList<>();
	private double sumPrice;

	public abstract boolean addShoppingItem(int bid);

	public abstract boolean addShoppingItem(Books book);

	public abstract boolean updateShoppingItem(int bid, int count);

	public abstract boolean removeItem(int bid);

	public List<ShoppingItem> getItems() {
		return items;
	}

	public double getSumPrice() {
		sumPrice = 0;
		for (ShoppingItem item : items) {
			sumPrice += item.getB_price();
		}
		return sumPrice;
	}

}
