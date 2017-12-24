package com.lxit.oa.beans;

/**
 * 文件
 * @author Administrator
 *
 */
public class File {

	private String id;
	private String filename;//文件名
	private String url;//文件路径
	private String type;//文件类型
	private String size;//文件大小
	private String createtime;//创建时间
	private User userID;//创建人(属于)
	private String state;//状态
	private String power;//权限
	private int downloadNum;//下载次数
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
		return "File [id=" + id + ", filename=" + filename + ", url=" + url + ", type=" + type + ", size=" + size
				+ ", createtime=" + createtime + ", userID=" + userID.getId() + ", state=" + state + ", power=" + power
				+ ", downloadNum=" + downloadNum + "]";
	}
	
	
	
}
