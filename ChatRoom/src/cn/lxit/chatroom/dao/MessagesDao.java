package cn.lxit.chatroom.dao;

import java.util.List;

import cn.lxit.chatroom.entity.Messages;

public interface MessagesDao {
	boolean insert(Messages m);
	List<Messages> select(Messages m);
}
