package com.yanalysis.oathink.common;

public class UserLoginException extends OAThinkException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserLoginException(){
		super(OAThinkError.USER_LOGIN_EXCEPTION, OAThinkError.USER_LOGIN_EXCEPTION_MSG);
	}

}
