package cn.lxit.books.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lxit.books.bean.Books;
import cn.lxit.books.service.BooksService;
import cn.lxit.books.service.ShoppingItemService;
import cn.lxit.books.service.impl.BooksServiceImpl;
import cn.lxit.books.service.impl.ShoppingItemServiceImpl;
import cn.lxit.books.util.Pager;

public class BooksServlet extends HttpServlet {

	ShoppingItemService shoppingItem = new ShoppingItemServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");

		BooksService books = new BooksServiceImpl();

		String oper = request.getParameter("oper");

		
		if ("index".equals(oper)) {

			List<Books> book = books.getBooks();// ²éÑ¯ËùÓÐ
			request.setAttribute("book", book);

			int pageIndex = request.getParameter("pageIndex") == null ? 1
					: Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize = request.getParameter("pageSize") == null ? 3
					: Integer.parseInt(request.getParameter("pageSize"));

			Pager<Books> page = books.getTopicsGetPageIndex(pageIndex, pageSize);
			request.setAttribute("page", page);

			request.getRequestDispatcher("/JBEshop/index.jsp").forward(request, response);
		} else if ("shoppingItem".equals(oper)) {
			int bid = Integer.parseInt(request.getParameter("bid"));
			shoppingItem.addShoppingItem(bid);

			request.getSession().setAttribute("shopping", shoppingItem);  

			response.sendRedirect("/books/JBEshop/shopping.jsp");

		}else if("shoppings".equals(oper)){
			String[] str = request.getParameterValues("bookId");
			for (String string : str) {
				int bid = Integer.parseInt(string);    
				shoppingItem.addShoppingItem(bid);
			}
			request.getSession().setAttribute("shopping", shoppingItem);

			response.sendRedirect("/books/JBEshop/shopping.jsp");
		}

	}

}
