package com.yanalysis.scas.user.model;

public class User {
	private final String uid;
    private final String name;
    private final String sid;
    
    
    
	public User(String uid, String name, String sid) {
		super();
		this.uid = uid;
		this.name = name;
		this.sid = sid;
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
