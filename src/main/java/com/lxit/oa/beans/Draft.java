package com.lxit.oa.beans;

/**
 * 草稿
 * @author Administrator
 *
 */
public class Draft {

	private String id;
	private String title;//标题
	private String text;//内容
	private String type;//类型
	private String createtime;//创建时间
	private String remark;//备注
	private String lasttime;//最后修改时间
	private User userID;//创建人（属于）
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getLasttime() {
		return lasttime;
	}
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	public User getUserID() {
		return userID;
	}
	public void setUserID(User userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "Draft [id=" + id + ", title=" + title + ", text=" + text + ", type=" + type + ", createtime="
				+ createtime + ", remark=" + remark + ", lasttime=" + lasttime + ", userID=" + userID.getId() + "]";
	}
	
	
	
	
}
