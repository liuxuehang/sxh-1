package cn.lxit.books.service.impl;

import java.util.List;

import cn.lxit.books.bean.Items;
import cn.lxit.books.dao.ItemsDao;
import cn.lxit.books.dao.impl.ItemsDaoImpl;
import cn.lxit.books.service.ItemsService;

public class ItemsServiceImpl implements ItemsService{
   
    ItemsDao item = new ItemsDaoImpl();
	@Override
	public boolean insertItems(Items items) {
		return item.insertItems(items);
	}

	@Override
	public List<Items> getItems() {
		return item.getItems();
	}

	@Override
	public List<Items> getItemsById(int oid) {
		return item.getItemsById(oid);
	}

	@Override
	public List<Items> getItemsByName(String userName) {
		return item.getItemsByName(userName);
	}
    
	
	

}
