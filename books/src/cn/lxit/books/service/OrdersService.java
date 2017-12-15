package cn.lxit.books.service;

public interface OrdersService {

	
	   //通过用户名查询订单
	   int checkOrders(String userName);
	   //插入订单
	   boolean insertOrders(int oid,String userName);
}
