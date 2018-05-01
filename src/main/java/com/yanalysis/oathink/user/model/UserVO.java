package com.yanalysis.oathink.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UserVO {
	private int uid;
    private String name;
    private String sid;
    private String pwd;
    private String code;
    
	public void setUid(int uid) {
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
	
	public int getUid() {
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
    
}
