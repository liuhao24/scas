package com.yanalysis.oathink.common;

public class OAThinkException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int code = 0;
	private String desc = "Unkown Exception!";
	
	public OAThinkException(int code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
