package com.lxit.oa.beans;

/**
 * 权限
 * @author Administrator
 *
 */
public class Power {

	private String id;
	private String text;//权限名称
	private String state;//状态
	private String url;//地址
	private String iconCls;//
	private String pid;//对应的父权限
	private String remark;//备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Power [id=" + id + ", text=" + text + ", state=" + state + ", url=" + url + ", iconCls=" + iconCls
				+ ", pid=" + pid + ", remark=" + remark + "]";
	}
	
	
	
}
