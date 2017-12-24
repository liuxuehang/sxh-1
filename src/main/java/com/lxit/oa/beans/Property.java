package com.lxit.oa.beans;

/**
 * 资产
 * @author Administrator
 *
 */
public class Property {

	private String id;
	private String number;//资产编号
	private PropertyGroup groupID;//资产组
	private String state;//资产状态
	private User userID;//资产使用人
	private String loseLevel;//耗损程度
	private String remark;//备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public PropertyGroup getGroupID() {
		return groupID;
	}
	public void setGroupID(PropertyGroup groupID) {
		this.groupID = groupID;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public User getUserID() {
		return userID;
	}
	public void setUserID(User userID) {
		this.userID = userID;
	}
	public String getLoseLevel() {
		return loseLevel;
	}
	public void setLoseLevel(String loseLevel) {
		this.loseLevel = loseLevel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Property [id=" + id + ", number=" + number + ", groupID=" + groupID.getId() + ", state=" + state + ", userID="
				+ userID.getId() + ", loseLevel=" + loseLevel + ", remark=" + remark + "]";
	}
	
	
	
}
