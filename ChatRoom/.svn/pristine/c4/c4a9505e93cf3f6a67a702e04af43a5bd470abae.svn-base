package cn.lxit.chatroom.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.lxit.chatroom.dao.BaseDao;
import cn.lxit.chatroom.dao.MessagesDao;
import cn.lxit.chatroom.entity.Messages;

public class MessagesDaoimpl extends BaseDao implements MessagesDao {

	@Override
	public boolean insert(Messages m) {
		String sql="insert into messages(m_from,m_to,m_message,m_addtime) values(?,?,?,now())";
		Object[] obj={m.getM_from(),m.getM_to(),m.getM_message()};
		return this.executeUpdate(sql, obj)>0;
	}

	@Override
	public List<Messages> select(Messages m) {
		List<Messages> li=new ArrayList<Messages>();
		String sql="SELECT m_from,m_to,m_message,m_addtime FROM messages where (m_from=? or m_to=? or m_to='ËùÓÐÈË') and m_addtime>=?";
		Object[] obj={m.getM_from() ,m.getM_from(),m.getM_addtime()};
		rs=this.executeQuery(sql, obj);
		try {
			while(rs.next()){
				Messages mm=new Messages();
				mm.setM_from(rs.getString("m_from"));
				mm.setM_to(rs.getString("m_to"));
				mm.setM_message(rs.getString("m_message"));
				mm.setM_addtime(rs.getString("m_addtime"));
				li.add(mm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return li;
	}

}
