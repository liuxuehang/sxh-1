package cn.lxit.books.service;

import java.util.List;

import cn.lxit.books.bean.Items;

public interface ItemsService {

	/**
     * 插入订单
     * @param items
     * @return
     */
	boolean insertItems(Items items);
    /**
     * 查询所有订单
     * @return
     */
	List<Items> getItems();
    /**
     * 根据订单id查询订单
     * @param oid
     * @return
     */
	List<Items> getItemsById(int oid);
    /**
     * 根据用户名称查询订单
     * @param userName
     * @return
     */
	public List<Items> getItemsByName(String userName);
}
