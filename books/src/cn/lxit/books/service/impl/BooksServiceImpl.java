package cn.lxit.books.service.impl;

import java.util.List;

import cn.lxit.books.bean.Books;
import cn.lxit.books.dao.BooksDao;
import cn.lxit.books.dao.impl.BooksDaoImpl;
import cn.lxit.books.service.BooksService;
import cn.lxit.books.util.Pager;

public class BooksServiceImpl implements BooksService {
    
	BooksDao bd = new BooksDaoImpl();
	@Override
	public Pager<Books> getTopicsGetPageIndex(int pageIndex, int pageSize) {
		return bd.getTopicsGetPageIndex(pageIndex, pageSize);
	}

	@Override
	public int getSumCount() {
		return bd.getSumCount();
	}

	@Override
	public List<Books> getBooks() {
		return bd.getBooks();
	}

	@Override
	public Books getBookById(int bid) {
		return bd.getBookById(bid);
	}

}
