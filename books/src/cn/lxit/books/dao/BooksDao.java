package cn.lxit.books.dao;

import java.util.List;

import cn.lxit.books.bean.Books;
import cn.lxit.books.util.Pager;

public interface BooksDao {

        
	
	    // 给书籍分页
		Pager<Books> getTopicsGetPageIndex(int pageIndex, int pageSize);

		// 总条数
		int getSumCount();
		
		//查询所有书籍
	    List<Books> getBooks();
	    
		Books getBookById(int bid);        
	
}
