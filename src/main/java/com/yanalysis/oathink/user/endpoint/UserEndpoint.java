package com.yanalysis.oathink.user.endpoint;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yanalysis.oathink.ResponseEntityDto;
import com.yanalysis.oathink.common.OAThinkError;
import com.yanalysis.oathink.common.UserLoginException;
import com.yanalysis.oathink.common.ValidateUtil;
import com.yanalysis.oathink.user.model.UserSignupVO;
import com.yanalysis.oathink.user.model.UserVO;
import com.yanalysis.oathink.user.service.UserService;

@Component
@Path("/user")
public class UserEndpoint {
	private static final Logger logger = LogManager.getLogger(UserEndpoint.class.getName());
	
	@Autowired
	private UserService userService = null;
	
	public UserEndpoint(UserService service) {
		this.userService = service;
	}
	
	@POST
	@Path("/signup/sms")
	@Consumes(APPLICATION_JSON)
	public Response regsms(final UserSignupVO signupVo) {
		String phone = signupVo.getPhone();
		ResponseEntityDto dto = new ResponseEntityDto();
		if (ValidateUtil.validatePhone(phone)) {
			userService.sendRegSms(phone);
			final ResponseBuilder responseBuilder = Response.status(200);
			dto.setCode(0);
			return responseBuilder.type(MediaType.APPLICATION_JSON).entity(dto).build();
		}else{
			final ResponseBuilder responseBuilder = Response.status(Status.BAD_REQUEST);
			dto.setCode(OAThinkError.VALIDATION_PHONE_ERROR);
			return responseBuilder.type(MediaType.APPLICATION_JSON).entity(dto).build();
		}
	    
	}
	
	@GET
	@Path("/signup/sms")
	public Response regNext(@QueryParam(value = "phone") String phone,
			@QueryParam(value = "code") String token) {
		ResponseEntityDto respEntity = new ResponseEntityDto();
		
		if(userService.authRegSms(phone, token)){
			respEntity.setCode(0);
			Map<String, String> data = new HashMap<>(1);
			data.put("code", token);
			respEntity.setData(data);
			final ResponseBuilder responseBuilder = Response.status(200);
		    return responseBuilder.type(MediaType.APPLICATION_JSON).entity(respEntity).build();
		}else{
			respEntity.setCode(OAThinkError.VALIDATION_CODE_ERROR);
			respEntity.setMessage(OAThinkError.VALIDATION_CODE_ERROR_MSG);
			final ResponseBuilder responseBuilder = Response.status(Status.BAD_REQUEST);
		    return responseBuilder.type(MediaType.APPLICATION_JSON).entity(respEntity).build();
		}
		
		
	}
	
	@POST
	@Path("/signup")
	@Consumes(APPLICATION_JSON)
	public Response createUser(final UserSignupVO signupVo) {
		ResponseEntityDto respEntity = new ResponseEntityDto();
		if(userService.authRegSms(signupVo.getPhone(), signupVo.getCode())){
			String sid = "";
			try {
				sid = userService.createUser(signupVo);
			} catch (UserLoginException e) {
				logger.error("UserEndpoint signup : ", e.getCause());
				respEntity.setCode(OAThinkError.VALIDATION_CODE_ERROR);
				respEntity.setMessage(OAThinkError.VALIDATION_CODE_ERROR_MSG);
				final ResponseBuilder responseBuilder = Response.status(Status.BAD_REQUEST);
			    return responseBuilder.type(MediaType.APPLICATION_JSON).entity(respEntity).build();
			}
			respEntity.setCode(0);
			signupVo.setSid(sid);
			respEntity.setData(signupVo);
			final ResponseBuilder responseBuilder = Response.status(200);
		    return responseBuilder.type(MediaType.APPLICATION_JSON).entity(respEntity).build();
		}else{
			respEntity.setCode(OAThinkError.VALIDATION_CODE_ERROR);
			respEntity.setMessage(OAThinkError.VALIDATION_CODE_ERROR_MSG);
			final ResponseBuilder responseBuilder = Response.status(Status.BAD_REQUEST);
		    return responseBuilder.type(MediaType.APPLICATION_JSON).entity(respEntity).build();
		}
	}
	
	@POST
	@Path("/signin")
	@Consumes(APPLICATION_JSON)
	public Response signin(final UserVO user) {
		ResponseEntityDto respEntity = new ResponseEntityDto();
		try {
			userService.login(user);
			respEntity.setCode(0);
			respEntity.setData(user.getSid());
		} catch (UserLoginException e) {
			logger.error("UserEndpoint signin : ", e.getCause());
			respEntity.setCode(e.getCode());
			respEntity.setMessage(e.getDesc());
		}
		
		final ResponseBuilder responseBuilder = Response.status(200);
	    return responseBuilder.type(MediaType.APPLICATION_JSON).entity(respEntity).build();
	}
}
