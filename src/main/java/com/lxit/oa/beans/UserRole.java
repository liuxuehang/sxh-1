package com.lxit.oa.beans;

/**
 * 用户和角色
 * @author Administrator
 *
 */
public class UserRole {

	private User uid;//用户
	private Role rid;//角色
	
	public User getUid() {
		return uid;
	}
	public void setUid(User uid) {
		this.uid = uid;
	}
	public Role getRid() {
		return rid;
	}
	public void setRid(Role rid) {
		this.rid = rid;
	}
	
	@Override
	public String toString() {
		return "UserRole [uid=" + uid.getId() + ", rid=" + rid.getId() + "]";
	}
	
	
	
}
