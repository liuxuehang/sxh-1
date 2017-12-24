package com.lxit.oa.beans;

/**
 * 角色
 * @author Administrator
 *
 */
public class Role {

	private String id;
	private String name;//角色名
	private String codeValue;//角色代码值
	private String createtime;//创建时间
	private String lasttime;//最后修改时间
	private User userID;//创建人
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
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getLasttime() {
		return lasttime;
	}
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", codeValue=" + codeValue + ", createtime=" + createtime
				+ ", lasttime=" + lasttime + ", remark=" + remark + "]";
	}
	
	
	
}
