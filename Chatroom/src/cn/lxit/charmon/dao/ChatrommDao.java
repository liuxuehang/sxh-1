package cn.lxit.charmon.dao;

import java.util.List;

import cn.lxit.charmon.ben.Messages;

public interface ChatrommDao {
	/**
	 * 增加聊天记录
	 * @param messages
	 * @return
	 */
  boolean insertChatrom(Messages messages);
  /**
   * 查询所有 
   * @param 
   * @return
   */
  List<Messages> getSelect();
  
  
  
}
