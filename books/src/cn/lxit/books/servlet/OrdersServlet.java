package cn.lxit.books.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lxit.books.bean.Items;
import cn.lxit.books.bean.ShoppingItem;
import cn.lxit.books.service.ItemsService;
import cn.lxit.books.service.OrdersService;
import cn.lxit.books.service.ShoppingItemService;
import cn.lxit.books.service.impl.ItemsServiceImpl;
import cn.lxit.books.service.impl.OrdersServiceImpl;
import cn.lxit.books.service.impl.ShoppingItemServiceImpl;

public class OrdersServlet extends HttpServlet {

	ItemsService Item = new ItemsServiceImpl();
	OrdersService orders = new OrdersServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");

		String oper = request.getParameter("oper");
		if ("items".equals(oper)) {

			String ui = (String) request.getSession().getAttribute("ui");
			if (ui == null) {
				response.sendRedirect("/books/JBEshop/login.jsp");
			} else if ("orderlist".equals(oper)) {
				
				if (request.getSession().getAttribute("ui") != null) {
					String usreName = (String) request.getSession().getAttribute("ui");
					List<Items> it = Item.getItemsByName(usreName);

					request.setAttribute("list", it);

					request.getRequestDispatcher("orderlist.jsp").forward(request, response);
				}

			} else {
				String userName = (String) request.getSession().getAttribute("userName");
				int count = 0;
				String[] nums = request.getParameterValues("nums");
				List<Items> items = new ArrayList<Items>();
				ShoppingItemService books = (ShoppingItemServiceImpl) request.getSession().getAttribute("shopCare");
				List<ShoppingItem> it1 = books.getItems();
				for (ShoppingItem books2 : it1) {
					Items it = new Items();
					int oid = (int) (Math.random() * 10000);
					orders.insertOrders(oid, userName);
					it.setBid(books2.getItem().getBid());
					it.setCount(Integer.parseInt(nums[count]));
					it.setPrice(books2.getItem().getB_price());
					it.setTotal_price(Integer.parseInt(nums[count]) * books2.getItem().getB_price());
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date date = new Date();
					String createDate = sf.format(date);
					it.setCreateDate(createDate);
					it.setOid(oid);
					it.setImages(books2.getItem().getImage());
					items.add(it);
					count++;
				}
				for (Items ite : items) {
					Item.insertItems(ite);
				}

			}

		}
	}
}
