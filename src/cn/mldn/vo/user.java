package cn.mldn.vo;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class user implements Serializable {
	private String username;
	private String password;
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
}
