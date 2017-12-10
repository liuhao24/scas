package com.yanalysis.oathink.entity;

import java.util.Date;

public class OAThinkUser{
	private String name = null;
	private String phone = null;
	private String email = null;
	private String nick = null;
	private String pwd = null;
	private String salt = null;
	private int id = 0;
	
	private Date createdAt = null;
	
	public OAThinkUser(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int uid) {
		this.id = uid;
	}
	
}
