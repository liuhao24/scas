package com.yanalysis.oathink.system.endpoint;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yanalysis.oathink.ResponseEntityDto;
import com.yanalysis.oathink.entity.OAThinkUser;
import com.yanalysis.oathink.orgnization.model.DepartmentVO;
import com.yanalysis.oathink.orgnization.service.OrgnService;
import com.yanalysis.oathink.user.model.UserVO;
import com.yanalysis.oathink.user.service.UserService;

@Component
@Path("/orgn")
public class OrgnSettingEndpoint {
	private static final Logger logger = LogManager.getLogger(OrgnSettingEndpoint.class.getName());

	@Autowired
	private OrgnService orgnService = null;
	@Autowired
	private UserService userService = null;

	public OrgnSettingEndpoint(OrgnService service, UserService userService) {
		this.orgnService = service;
		this.userService = userService;
	}

	@POST
	@Path("/department")
	@Consumes(APPLICATION_JSON)
	public Response createDepartment(@HeaderParam("sid") String sid, 
			final DepartmentVO department) {
		UserVO user = userService.getUserBySid(sid);
		logger.debug("create department:{} for user:{}", department, user);
		orgnService.createDepartment(user, department);
		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setData(department);
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}
	
	@DELETE
	@Path("/department")
	@Consumes(APPLICATION_JSON)
	public Response delDepartment(@HeaderParam("sid") String sid, 
			final DepartmentVO department) {
		UserVO user = userService.getUserBySid(sid);
		logger.debug("disable department:{} for user:{}", department, user);
		orgnService.disableDepartment(user, department.getId());
		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setData(department);
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}
	
	@PUT
	@Path("/department")
	@Consumes(APPLICATION_JSON)
	public Response updateDepartment(@HeaderParam("sid") String sid, 
			final DepartmentVO department) {
		UserVO user = userService.getUserBySid(sid);
		logger.debug("update department:{} for user:{}", department, user);
		orgnService.updateDepartment(user, department);
		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setData(department);
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}
	
	@GET
	@Path("/department/{id}")
	@Consumes(APPLICATION_JSON)
	public Response findDepartment(@HeaderParam("sid") String sid, 
			@PathParam("id") final String gid) {
		UserVO user = userService.getUserBySid(sid);
		logger.debug("find department:{} for user:{}", gid, user);
		DepartmentVO department = orgnService.findDepartment(user, gid);
		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setData(department);
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}
	
	@GET
	@Path("/department/list")
	@Consumes(APPLICATION_JSON)
	public Response listDepartment(@HeaderParam("sid") String sid, 
			@QueryParam("domain")final String domain) {
		UserVO user = userService.getUserBySid(sid);
		logger.debug("list department:{} for user:{}", domain, user);
		List<DepartmentVO> department = orgnService.listDepartment(user, domain);
		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setData(department);
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}

}
