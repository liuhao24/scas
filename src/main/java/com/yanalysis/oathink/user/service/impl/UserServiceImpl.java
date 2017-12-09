package com.yanalysis.oathink.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanalysis.oathink.common.OAThinkFields;
import com.yanalysis.oathink.component.OAThinkCacheComp;
import com.yanalysis.oathink.entity.OAThinkOrgn;
import com.yanalysis.oathink.entity.OAThinkUser;
import com.yanalysis.oathink.entity.mapper.OrginizationMapper;
import com.yanalysis.oathink.user.model.CompanyVO;
import com.yanalysis.oathink.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	OAThinkCacheComp cacheComp = null;
	
	@Autowired
	OrginizationMapper orgnMapper = null;

	public OAThinkUser initOrg(CompanyVO company) {
		OAThinkUser user = new OAThinkUser();
		OAThinkOrgn orgn = new OAThinkOrgn();
		orgn.setName(company.getOrgName());
		orgn.setEmail(company.getPhone());
		orgnMapper.insert(orgn);
		return user;
	}

	public void sendRegSms(String phone) {
		cacheComp.set(OAThinkFields.PREFIX_SMS_REG + phone, "123456");
	}

}
