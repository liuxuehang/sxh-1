package cn.lxit.books.util;

import java.util.List;

public class Pager<T> {

	private int pageIndex;// 当前页
	private int pageSize;// 每页显示的条数
	private int sumCount;// 总条数
	private int sumpage;// 总页数
	private boolean isFirst;// 是不是第首页
	private boolean isLast;// 是不是尾页
	private List<T> data;// 查询出来的数据

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		if (pageIndex < 1) {
			this.pageIndex = 1;
		} else {
			this.pageIndex = pageIndex;
		}

	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSumCount() {
		return sumCount;
	}

	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;

		this.sumpage = this.sumCount % pageSize == 0 ? this.sumCount / pageSize : this.sumCount / pageSize + 1;

		if (this.pageIndex > this.sumpage && this.sumpage > 0) {
			this.pageIndex = this.sumpage;
		}
	}
      
	public int getSumpage() {
		return sumpage;  
	}

	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public boolean getIsFirst() {
		return this.pageIndex <= 1;
	}

	public boolean getIsLast() {
		return this.pageIndex >= this.sumpage;
	}
	
	

}
