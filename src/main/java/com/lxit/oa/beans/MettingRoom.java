package com.lxit.oa.beans;

/**
 * 会议室
 * @author Administrator
 *
 */
public class MettingRoom {

	private String id;
	private String name;//会议室名称
	private String describe;//会议室描述
	private String create;//创建时间
	private User principal;//负责人
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
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getCreate() {
		return create;
	}
	public void setCreate(String create) {
		this.create = create;
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
		return "MettingRoom [id=" + id + ", name=" + name + ", describe=" + describe + ", create=" + create
				+ ", principal=" + principal.getId() + ", remark=" + remark + "]";
	}
	
	
	
	
}
