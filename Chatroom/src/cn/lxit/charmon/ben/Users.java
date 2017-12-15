package cn.lxit.charmon.ben;

public class Users {
private String u_name;//用户名
private String u_pass;//密码
private String u_nickName;//昵称
private int u_status;//状态0不在线1在线
private String u_addtime;//注册时间
public Users(String u_name, String u_pass, String u_nickName, int u_status, String u_addtime) {
	super();
	this.u_name = u_name;
	this.u_pass = u_pass;
	this.u_nickName = u_nickName;
	this.u_status = u_status;
	this.u_addtime = u_addtime;
}
public Users() {
	super();
}
public String getU_name() {
	return u_name;
}
public void setU_name(String u_name) {
	this.u_name = u_name;
}
public String getU_pass() {
	return u_pass;
}
public void setU_pass(String u_pass) {
	this.u_pass = u_pass;
}
public String getU_nickName() {
	return u_nickName;
}
public void setU_nickName(String u_nickName) {
	this.u_nickName = u_nickName;
}
public int getU_status() {
	return u_status;
}
public void setU_status(int u_status) {
	this.u_status = u_status;
}
public String getU_addtime() {
	return u_addtime;
}
public void setU_addtime(String u_addtime) {
	this.u_addtime = u_addtime;
}

}
