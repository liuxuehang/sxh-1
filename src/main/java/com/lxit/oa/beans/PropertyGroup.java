package com.lxit.oa.beans;

/**
 * 资产组
 * @author Administrator
 *
 */
public class PropertyGroup {

	private String id;
	private String type;//类型（笔记本，打印机...）
	private String name;//资产名称
	private String model;//规格型号
	private int number;//数量
	private User create;//创建人
	private String createtime;//创建时间
	private User principal;//岗位编号外键 ,负责人
	private int allotNum;//已分配编号数量
	private String remark;//备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public User getCreate() {
		return create;
	}
	public void setCreate(User create) {
		this.create = create;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public User getPrincipal() {
		return principal;
	}
	public void setPrincipal(User principal) {
		this.principal = principal;
	}
	public int getAllotNum() {
		return allotNum;
	}
	public void setAllotNum(int allotNum) {
		this.allotNum = allotNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "PropertyGroup [id=" + id + ", type=" + type + ", name=" + name + ", model=" + model + ", number="
				+ number + ", create=" + create.getId() + ", createtime=" + createtime + ", principal=" + principal.getId()
				+ ", allotNum=" + allotNum + ", remark=" + remark + "]";
	}
	
	
	
}
