package com.lxit.oa.beans;

/**
 * 文件夹
 * @author Administrator
 *
 */
public class Folder {

	private String id;
	private String name;//文件夹名
	private String url;//文件夹路径
	private String createtime;//文件夹创建时间
	private User userID;//创建人（属于）
	private String remark;//备注
	private String state;//状态
	private String power;//权限
	private int downloadNum;//下载次数
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public int getDownloadNum() {
		return downloadNum;
	}
	public void setDownloadNum(int downloadNum) {
		this.downloadNum = downloadNum;
	}
	@Override
	public String toString() {
		return "Folder [id=" + id + ", name=" + name + ", url=" + url + ", createtime=" + createtime + ", userID="
				+ userID.getId() + ", remark=" + remark + ", state=" + state + ", power=" + power + ", downloadNum="
				+ downloadNum + "]";
	}
	
	
	
}
