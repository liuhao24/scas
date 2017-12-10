package com.yanalysis.oathink.user.endpoint;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yanalysis.oathink.ResponseEntityDto;
import com.yanalysis.oathink.common.OAThinkError;
import com.yanalysis.oathink.common.UserLoginException;
import com.yanalysis.oathink.user.model.CompanyVO;
import com.yanalysis.oathink.user.model.UserVO;
import com.yanalysis.oathink.user.service.UserService;

@Component
@Path("/")
public class UserEndpoint {
	private static final Logger logger = LogManager.getLogger(UserEndpoint.class.getName());
	
	@Autowired
	private UserService userService = null;
	
	public UserEndpoint(UserService service) {
		this.userService = service;
	}
	
	@GET
	@Path("/reg/sms")
	public Response regsms(@QueryParam(value = "phone") String phone) {
		userService.sendRegSms(phone);
		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto error = new ResponseEntityDto();
		error.setCode(0);
	    return responseBuilder.type(MediaType.APPLICATION_JSON).entity(error).build();
	}
	
	@GET
	@Path("/reg/next")
	@Consumes(APPLICATION_JSON)
	public Response regNext(@QueryParam(value = "phone") String phone,
			@QueryParam(value = "token") String token) {
		ResponseEntityDto respEntity = new ResponseEntityDto();
		
		if(userService.authRegSms(phone, token)){
			respEntity.setCode(0);
		}else{
			respEntity.setCode(OAThinkError.VALIDATION_CODE_ERROR);
			respEntity.setMessage(OAThinkError.VALIDATION_CODE_ERROR_MSG);
		}
		
		final ResponseBuilder responseBuilder = Response.status(200);
	    return responseBuilder.type(MediaType.APPLICATION_JSON).entity(respEntity).build();
	}
	
	@POST
	@Path("/reg/submit")
	@Consumes(APPLICATION_JSON)
	public Response regtoken(final CompanyVO company) {
		userService.initOrg(company);
		ResponseEntityDto respEntity = new ResponseEntityDto();
		respEntity.setCode(0);
		final ResponseBuilder responseBuilder = Response.status(200);
	    return responseBuilder.type(MediaType.APPLICATION_JSON).entity(respEntity).build();
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
