package com.yanalysis.oathink.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UserSignupVO {
	private String uid;
    private String name;
    private String sid;
    private String pwd;
    private String phone;
    private String code;
    
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

	public UserSignupVO() {
		
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
}
