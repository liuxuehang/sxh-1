package cn.lxit.books.service.impl;

import cn.lxit.books.bean.Books;
import cn.lxit.books.bean.ShoppingItem;
import cn.lxit.books.service.BooksService;
import cn.lxit.books.service.ShoppingItemService;

public class ShoppingItemServiceImpl extends ShoppingItemService {
   
	@Override//添加单个商品
	public boolean addShoppingItem(int bid) {
		ShoppingItem shoppingItem = null;

		// 判断bid的商品是否在购物车已存在
		for (ShoppingItem item : this.getItems()) {
			if (item.getItem().getBid() == bid) {
				shoppingItem = item;
				break;
			}
		}
     
		if (shoppingItem == null) {  
			// 商品不存在，添加商品
			BooksService book = new BooksServiceImpl();
			// 根据商品的编号查询商品
			Books books = book.getBookById(bid);
			// 要添加的商品对象
			ShoppingItem bItem = new ShoppingItem();
			bItem.setItem(books);
			bItem.setCount(1);
			// 把商品加入购物车
			this.getItems().add(bItem);
		} else {
			// 如果商品已经存在,在他原来的数量上加一
			shoppingItem.setCount(shoppingItem.getCount() + 1);
		}

		return true;
	}

	@Override//一次添加多个商品
	public boolean addShoppingItem(Books book) {
		ShoppingItem shoppingItem = null;

		// 判断bid的商品是否在购物车已存在
		for (ShoppingItem item : this.getItems()) {
			if (item.getItem().getBid() == book.getBid()) {
				shoppingItem = item;
				break;
			}
		}

		if (shoppingItem == null) {
			// 要添加的商品对象
			ShoppingItem bItem = new ShoppingItem();
			bItem.setItem(book);
			bItem.setCount(1);
			// 把商品加入购物车
			this.getItems().add(bItem);
		} else {
			// 如果商品已经存在,在他原来的数量上加一
			shoppingItem.setCount(shoppingItem.getCount() + 1);
		}

		return true;
	}
               
	@Override  
	public boolean updateShoppingItem(int bid, int count) {
		ShoppingItem shoppingItem = null;
		// 判断商品是否存在
		for (ShoppingItem item : this.getItems()) {
			if (item.getItem().getBid() == bid) {
				shoppingItem = item;
				break;
			}
		}

		shoppingItem.setCount(count);
		return true;
	}

	@Override
	public boolean removeItem(int bid) {
		ShoppingItem shoppingItem = null;
		// 判断商品是否存在
		for (ShoppingItem item : this.getItems()) {
			if (item.getItem().getBid() == bid) {
				shoppingItem = item;
				break;
			}
		}

		this.getItems().remove(shoppingItem);
		return true;
	}

}
