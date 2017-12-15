package cn.lxit.chatroom.service.impl;

import java.util.List;

import cn.lxit.chatroom.dao.MessagesDao;
import cn.lxit.chatroom.dao.impl.MessagesDaoimpl;
import cn.lxit.chatroom.entity.Messages;
import cn.lxit.chatroom.service.MessagesServiceDao;


public class MessagesServiceDaoimpl implements MessagesServiceDao {
	MessagesDao ms=new MessagesDaoimpl();
	@Override
	public boolean insert(Messages m) {
		
		return ms.insert(m);
	}

	@Override
	public List<Messages> select(Messages m) {
		
		return ms.select(m);
	}

}
