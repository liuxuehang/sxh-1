package com.lxit.oa.beans;

/**
 * 操作日志
 * @author Administrator
 *
 */
public class Log {

	private String id;
	private User userID;//操作人的名字
	private String event;//事件
	private String createtime;//操作时间
	private String remark;//备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUserID() {
		return userID;
	}
	public void setUserID(User userID) {
		this.userID = userID;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", userID=" + userID.getId() + ", event=" + event + ", createtime=" + createtime + ", remark="
				+ remark + "]";
	}
	
	
	
	
}
