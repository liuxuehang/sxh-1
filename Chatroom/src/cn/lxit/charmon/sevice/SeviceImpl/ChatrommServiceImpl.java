package cn.lxit.charmon.sevice.SeviceImpl;

import java.util.List;

import cn.lxit.charmon.ben.Messages;
import cn.lxit.charmon.dao.ChatrommDao;
import cn.lxit.charmon.dao.impl.ChatrommDaoImpl;
import cn.lxit.charmon.sevice.ChatrommSevice;

public class ChatrommServiceImpl implements ChatrommSevice {
    ChatrommDao chatrommDao=new ChatrommDaoImpl();
	@Override
	public boolean insertChatrom(Messages messages) {
		// TODO Auto-generated method stub
		return chatrommDao.insertChatrom(messages);
	}

	@Override
	public List<Messages> getSelect() {
		// TODO Auto-generated method stub
		return chatrommDao.getSelect();
	}

}
