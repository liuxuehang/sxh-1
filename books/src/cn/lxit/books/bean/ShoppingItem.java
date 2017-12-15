package cn.lxit.books.bean;

/**
 * 商品类
 * 
 * @author Administrator
 *
 */
public class ShoppingItem {

	// 购买的商品
	private Books item;
	// 商品的数量
	private int count;
	// 商品的价格
	private double b_price;

	public Books getItem() {
		return item;
	}

	public void setItem(Books item) {
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * 获取商品的小计
	 * 
	 * @return
	 */
	public double getB_price() {
		b_price = item.getB_price() * count;
		return b_price;
	}

	public void setPrice(double b_price) {
		this.b_price = b_price;
	}

}
