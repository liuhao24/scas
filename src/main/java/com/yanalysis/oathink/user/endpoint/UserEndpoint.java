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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yanalysis.oathink.ErrorDto;
import com.yanalysis.oathink.user.model.CompanyVO;
import com.yanalysis.oathink.user.service.UserService;

@Component
@Path("/")
public class UserEndpoint {
	
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
		ErrorDto error = new ErrorDto();
		error.setCode(0);
	    return responseBuilder.type(MediaType.APPLICATION_JSON).entity(error).status(200).build();
	}
	
	@POST
	@Path("/reg")
	@Consumes(APPLICATION_JSON)
	public String regtoken(final CompanyVO company) {
		
		userService.initOrg(company);
		return "sfadfasdfasdfasf";
	}
	
//	@GET
//	@Path("/signin")
//	public String regsubmit(@QueryParam(value = "orgdomain") String orgdomain,
//			@QueryParam(value = "ecode") String ecode,
//			@QueryParam(value = "passwd") String passwd) {
//		return "sfadfasdfasdfasf";
//	}
}
