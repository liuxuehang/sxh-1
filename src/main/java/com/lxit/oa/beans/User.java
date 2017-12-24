package com.lxit.oa.beans;

/**
 * 员工类
 * @author Administrator
 *
 */
public class User {

	private String id;//
	private String name;//姓名
	private String number;//编号
	private String password;//密码
	private String sex;//性别
	private String synopsis;//简介
	private String phone;//电话
	private String email;//邮箱
	private String state;//状态
	private String img;//头像
	private String workstate;//工作状态
	private String entrytime;//录入时间
	private String entryuser;//录入人
	private String logintime;//登录时间
	private String lastAmendtime;//最后修改时间
	private Role roleID;//角色
	private Department departmentID;//部门ID
	
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getWorkstate() {
		return workstate;
	}
	public void setWorkstate(String workstate) {
		this.workstate = workstate;
	}
	public String getEntrytime() {
		return entrytime;
	}
	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}
	public String getEntryuser() {
		return entryuser;
	}
	public void setEntryuser(String entryuser) {
		this.entryuser = entryuser;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	public String getLastAmendtime() {
		return lastAmendtime;
	}
	public void setLastAmendtime(String lastAmendtime) {
		this.lastAmendtime = lastAmendtime;
	}
	public Role getRoleID() {
		return roleID;
	}
	public void setRoleID(Role roleID) {
		this.roleID = roleID;
	}
	public Department getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(Department departmentID) {
		this.departmentID = departmentID;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", number=" + number + ", password=" + password + ", sex=" + sex
				+ ", synopsis=" + synopsis + ", phone=" + phone + ", email=" + email + ", state=" + state + ", img="
				+ img + ", workstate=" + workstate + ", entrytime=" + entrytime + ", entryuser=" + entryuser
				+ ", logintime=" + logintime + ", lastAmendtime=" + lastAmendtime + "]";
	}
	
	
	
	
	
	
	
}
