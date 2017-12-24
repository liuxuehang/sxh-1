package com.lxit.oa.beans;

/**
 * 数据字典
 * @author Administrator
 *
 */
public class Dictionaries {

	private String id;
	private String name;//名称
	private String codeValue;//代码值
	private String dataValue;//数据值
	private String lasttime;//最后修改时间
	private User userID;//操作人
	private String remark;//备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Dictionaries [id=" + id + ", name=" + name + ", codeValue=" + codeValue + ", dataValue=" + dataValue
				+ ", lasttime=" + lasttime + ", userID=" + userID.getId() + ", remark=" + remark + "]";
	}
	
	
	
}
