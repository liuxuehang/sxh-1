package com.lxit.oa.beans;

/**
 * 部门
 * @author Administrator
 *
 */
public class Department {

	private String id;
	private String name;//部门名称
	private String codeValue;//部门代码值
	private User userID;//负责人
	private String phone;//部门联系电话
	private String mobilePhone;//移动电话
	private String remark;//部门备注
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", codeValue=" + codeValue + ", phone=" + phone
				+ ", mobilePhone=" + mobilePhone + ", remark=" + remark + "]";
	}
	
	
	
	
}
