package cn.lxit.books.service.impl;

import cn.lxit.books.dao.OrdersDao;
import cn.lxit.books.dao.impl.OrdersDaoImpl;
import cn.lxit.books.service.OrdersService;

public class OrdersServiceImpl implements OrdersService{
    
	
	OrdersDao orders = new OrdersDaoImpl();
	@Override
	public int checkOrders(String userName) {
		return orders.checkOrders(userName);
	}

	@Override
	public boolean insertOrders(int oid, String userName) {
		return orders.insertOrders(oid, userName);
	}

}
