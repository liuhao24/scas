package com.yanalysis.oathink.orgnization.endpoint;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.Consumes;
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
import com.yanalysis.oathink.orgnization.model.DepartmentVO;
import com.yanalysis.oathink.orgnization.model.TeamVO;
import com.yanalysis.oathink.orgnization.service.TeamService;
import com.yanalysis.oathink.user.model.UserVO;
import com.yanalysis.oathink.user.service.UserService;

@Component
@Path("/team")
public class TeamEndpoint {
	private static final Logger logger = LogManager.getLogger(TeamEndpoint.class.getName());

	@Autowired
	private TeamService teamService = null;
	@Autowired
	private UserService userService = null;

	public TeamEndpoint(TeamService service, UserService userService) {
		this.teamService = service;
		this.userService = userService;
	}

	@POST
	@Consumes(APPLICATION_JSON)
	public Response createTeam(@HeaderParam("sid") String sid, final TeamVO teamvo) {
		UserVO user = userService.getUserBySid(sid);
		logger.debug("create team:{} for user:{}", teamvo.getOrgDomain(), user);
		teamService.createTeam(user, teamvo);
		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setData(teamvo);
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}
	
	@GET
	@Path("/list")
	@Consumes(APPLICATION_JSON)
	public Response listTeam(@HeaderParam("sid") String sid) {
		UserVO user = userService.getUserBySid(sid);
		logger.debug("list team for user:{}", user);
		List<TeamVO> teams = teamService.findTeamByUser(user.getUid());
		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setData(teams);
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}

	@GET
	@Path("/{domain}")
	@Consumes(APPLICATION_JSON)
	public Response checkTeam(@HeaderParam("sid") String sid, @PathParam("domain") final String domain) {
		UserVO user = userService.getUserBySid(sid);
		logger.debug("find team:{} for user:{}", domain, user);
		TeamVO team = teamService.findTeamByDomain(user, domain);
		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setData(team);
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}

	@POST
	@Path("/invite")
	@Consumes(APPLICATION_JSON)
	public Response invite(@HeaderParam("sid") String sid, final DepartmentVO department) {
		UserVO user = userService.getUserBySid(sid);

		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setData(department);
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}

	@POST
	@Path("/member")
	@Consumes(APPLICATION_JSON)
	public Response addMember(@HeaderParam("sid") String sid, final DepartmentVO department) {
		UserVO user = userService.getUserBySid(sid);

		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setData(department);
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}

	@POST
	@Path("/member/list")
	@Consumes(APPLICATION_JSON)
	public Response listMembers(@HeaderParam("sid") String sid, final DepartmentVO department) {
		UserVO user = userService.getUserBySid(sid);

		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setData(department);
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}

	@GET
	@Path("/link/signup")
	@Consumes(APPLICATION_JSON)
	public Response getSignupLink(@HeaderParam("sid") String sid, @QueryParam("domain") final String domain) {
		UserVO user = userService.getUserBySid(sid);
		logger.debug("list department:{} for user:{}", domain, user);

		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}

	@PUT
	@Path("/link/signup")
	@Consumes(APPLICATION_JSON)
	public Response resetSignupLink(@HeaderParam("sid") String sid, @QueryParam("domain") final String domain) {
		UserVO user = userService.getUserBySid(sid);
		logger.debug("list department:{} for user:{}", domain, user);

		final ResponseBuilder responseBuilder = Response.status(200);
		ResponseEntityDto resp = new ResponseEntityDto();
		resp.setCode(0);
		return responseBuilder.type(MediaType.APPLICATION_JSON).entity(resp).build();
	}

}
