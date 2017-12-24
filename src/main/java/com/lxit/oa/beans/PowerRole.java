package com.lxit.oa.beans;

/**
 * 权限AND角色中间表
 * @author Administrator
 *
 */
public class PowerRole {

	private Role rid;//角色
	private Power pid;//权限
	public Role getRid() {
		return rid;
	}
	public void setRid(Role rid) {
		this.rid = rid;
	}
	public Power getPid() {
		return pid;
	}
	public void setPid(Power pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "PowerRole [rid=" + rid.getId() + ", pid=" + pid.getId() + "]";
	}
	
	
	
}
