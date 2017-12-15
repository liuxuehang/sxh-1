package cn.lxit.charmon.sevice;

import java.util.List;

import cn.lxit.charmon.ben.Messages;

public interface ChatrommSevice {
	/**
	 * 增加聊天记录
	 * @param messages
	 * @return
	 */
  boolean insertChatrom(Messages messages);
  /**
   * 查询所有 
   * @param m_id
   * @return
   */
  List<Messages> getSelect();
}
