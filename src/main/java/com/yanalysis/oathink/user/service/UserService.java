package com.yanalysis.oathink.user.service;

import com.yanalysis.oathink.entity.OAThinkUser;
import com.yanalysis.oathink.user.model.CompanyVO;

public interface UserService {

	OAThinkUser initOrg(CompanyVO company);

	void sendRegSms(String phone);
	
	
}
