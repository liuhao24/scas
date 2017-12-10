package com.yanalysis.oathink.user.model;

public class UserVO {
	private String uid;
    private String name;
    private String sid;
    private String pwd;
    
	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public UserVO() {
		
	}
	
	public String getUid() {
		return uid;
	}
	public String getName() {
		return name;
	}
	public String getSid() {
		return sid;
	}
    
    
    
}
