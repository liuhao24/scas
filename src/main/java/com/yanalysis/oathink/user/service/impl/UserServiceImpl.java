package com.yanalysis.oathink.user.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanalysis.oathink.common.OAThinkFields;
import com.yanalysis.oathink.common.OAThinkJsonFactory;
import com.yanalysis.oathink.common.PasswordAuthentication;
import com.yanalysis.oathink.common.UserLoginException;
import com.yanalysis.oathink.component.OAThinkCacheComp;
import com.yanalysis.oathink.entity.OAThinkOrgn;
import com.yanalysis.oathink.entity.OAThinkUser;
import com.yanalysis.oathink.entity.mapper.OAThinkUserMapper;
import com.yanalysis.oathink.entity.mapper.OrginizationMapper;
import com.yanalysis.oathink.user.model.CompanyVO;
import com.yanalysis.oathink.user.model.UserVO;
import com.yanalysis.oathink.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	OAThinkCacheComp cacheComp = null;
	
	@Autowired
	OrginizationMapper orgnMapper = null;
	
	@Autowired
	OAThinkUserMapper userMapper = null;
	
	private PasswordAuthentication passwdAuth = new PasswordAuthentication();

	public OAThinkUser initOrg(CompanyVO company) {
		OAThinkUser user = new OAThinkUser();
		String salt = passwdAuth.genSalt();
		String pwd = passwdAuth.hash(company.getPasswd().getBytes(), salt.getBytes());
		
		user.setName(company.getUserName());
		user.setPhone(company.getPhone());
		user.setPwd(pwd);
		user.setSalt(salt);
		
		int uid = userMapper.insert(user);
		user.setId(uid);
		
		OAThinkOrgn orgn = new OAThinkOrgn();
		orgn.setName(company.getOrgName());
		orgn.setEmail(company.getPhone());
		orgn.setDomain(company.getOrgDomain());
		orgn.setCreateBy(uid + "");
		
		orgnMapper.insert(orgn);
		return user;
	}

	public void sendRegSms(String phone) {
		cacheComp.set(OAThinkFields.PREFIX_SMS_REG + phone, "123456");
	}

	@Override
	public boolean authRegSms(String phone, String token) {
		
		return token.equals(cacheComp.get(OAThinkFields.PREFIX_SMS_REG + phone));
	}

	@Override
	public boolean login(UserVO user) throws UserLoginException{
		OAThinkUser entity = userMapper.findByName(user.getName());
		if(!passwdAuth.authenticate(user.getPwd().getBytes(), entity.getPwd(), entity.getSalt().getBytes())){
			throw new UserLoginException();
		};
		String sid = RandomStringUtils.randomAlphanumeric(16);
		user.setUid(entity.getId() +"");
		user.setSid(sid);
		cacheComp.set(OAThinkFields.PREFIX_SID + sid, OAThinkJsonFactory.toJson(user));
		return true;
	}

	@Override
	public UserVO getUserBySid(String sid) {
		String jsonStr = cacheComp.get(OAThinkFields.PREFIX_SID + sid);
		return null == jsonStr?null:OAThinkJsonFactory.fromJson(jsonStr, UserVO.class);
	}

}
