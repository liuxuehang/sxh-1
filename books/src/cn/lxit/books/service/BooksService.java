package cn.lxit.books.service;

import java.util.List;

import cn.lxit.books.bean.Books;
import cn.lxit.books.util.Pager;

public interface BooksService {
	
	//查询所有书籍
    List<Books> getBooks();
    
	// 给书籍分页
	Pager<Books> getTopicsGetPageIndex(int pageIndex, int pageSize);

	// 总条数
	int getSumCount();
	
    
	Books getBookById(int bid);   
}
   