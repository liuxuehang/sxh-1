package cn.lxit.charmon.ben;

public class Messages {
private int m_id;
private String m_from;//发送人
private String m_to;//收信人
private String m_message;//聊天内容
private String m_addtime;//发送时间
public Messages(int m_id, String m_from, String m_to, String m_message, String m_addtime) {
	super();
	this.m_id = m_id;
	this.m_from = m_from;
	this.m_to = m_to;
	this.m_message = m_message;
	this.m_addtime = m_addtime;
}
public Messages() {
	super();
}
public int getM_id() {
	return m_id;
}
public void setM_id(int m_id) {
	this.m_id = m_id;
}
public String getM_from() {
	return m_from;
}
public void setM_from(String m_from) {
	this.m_from = m_from;
}
public String getM_to() {
	return m_to;
}
public void setM_to(String m_to) {
	this.m_to = m_to;
}
public String getM_message() {
	return m_message;
}
public void setM_message(String m_message) {
	this.m_message = m_message;
}
public String getM_addtime() {
	return m_addtime;
}
public void setM_addtime(String m_addtime) {
	this.m_addtime = m_addtime;
}

}
