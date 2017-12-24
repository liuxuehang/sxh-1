package com.lxit.oa.beans;

/**
 * 车辆信息
 * @author Administrator
 *
 */
public class Car {

	private String id;
	private String plateNumber;//车牌号
	private String type;//车型
	private String number;//编号
	private String state;//状态
	private User principal;//负责人
	private String remark;//备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public User getPrincipal() {
		return principal;
	}
	public void setPrincipal(User principal) {
		this.principal = principal;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", plateNumber=" + plateNumber + ", type=" + type + ", number=" + number + ", state="
				+ state + ", principal=" + principal.getId() + ", remark=" + remark + "]";
	}
	
	
	
}
