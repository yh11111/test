package cn.mldn.vo;

import java.io.Serializable;

public class item implements Serializable{
	private String username;
	private Integer id;
	private String item;
	
	public item() {
	}
	public item(String username, Integer id, String item) {
		super();
		this.username = username;
		this.id = id;
		this.item = item;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
}
