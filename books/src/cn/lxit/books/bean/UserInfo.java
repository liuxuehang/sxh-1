package cn.lxit.books.bean;

public class UserInfo {

	private String username;// 用户名称
	private String password;// 用户密码
	private String email;// 邮箱

	public UserInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserInfo(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
