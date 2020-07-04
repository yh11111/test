package cn.mldn.vo;

import java.io.Serializable;



import java.util.Date;

public class income implements Serializable {
	private String username;
	private Integer id;
	private Double money;
	private Date date;
	private String itemname;
	private String remark;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getItemname() {
		return itemname;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
