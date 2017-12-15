package cn.lxit.books.bean;

public class Books {
	
	private int bid;// 图书id
	private String bookname;// 图书名称
	private double b_price;// 价格
	private String image;// 图书图片的存放路径
	private int stock;// 库存数

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public double getB_price() {
		return b_price;
	}

	public void setB_price(double b_price) {
		this.b_price = b_price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
}
