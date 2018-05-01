package com.yanalysis.oathink.user.service;

import com.yanalysis.oathink.common.UserLoginException;
import com.yanalysis.oathink.entity.OAThinkUser;
import com.yanalysis.oathink.user.model.CompanyVO;
import com.yanalysis.oathink.user.model.UserSignupVO;
import com.yanalysis.oathink.user.model.UserVO;

public interface UserService {

	OAThinkUser initOrg(CompanyVO company);

	void sendRegSms(String phone);

	boolean authRegSms(String phone, String token);

	boolean login(UserVO user) throws UserLoginException;

	UserVO getUserBySid(String sid);

	String createUser(UserSignupVO signupVo) throws UserLoginException;
	
}
