package cn.lxit.charmon.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.lxit.charmon.ben.Messages;
import cn.lxit.charmon.ben.Users;
import cn.lxit.charmon.dao.BaseDao;
import cn.lxit.charmon.dao.ChatrommDao;

public class ChatrommDaoImpl extends BaseDao implements ChatrommDao {

	@Override
	public boolean insertChatrom(Messages messages) {
		String sql = "INSERT INTO messages (m_from,m_to,m_message,m_addtime)VALUES(?,?,?,now())";
		Object[] parms = { messages.getM_from(), messages.getM_to(), messages.getM_message()};

		return this.executeUpdate(sql, parms) > 0;
	}

	@Override
	public List<Messages> getSelect() {
		List<Messages> list = new ArrayList();
		String sql = "SELECT * FROM messages ";

		try {
			this.rs = this.executeQuery(sql, new Object[0]);
			while (rs.next()) {
				Messages msg = MessagesModel(rs);
				list.add(msg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}

		return list;
	}

	private Messages MessagesModel(ResultSet rs) {
		Messages messages = new Messages();
		try {
			messages.setM_from(rs.getString("m_from"));
			messages.setM_to(rs.getString("m_to"));
			messages.setM_message(rs.getString("m_message"));
			messages.setM_addtime(rs.getString("m_addtime"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messages;
	}
}
