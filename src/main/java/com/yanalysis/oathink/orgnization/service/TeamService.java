package com.yanalysis.oathink.orgnization.service;

import java.util.List;

import com.yanalysis.oathink.orgnization.model.TeamVO;
import com.yanalysis.oathink.user.model.UserVO;

public interface TeamService {
	public TeamVO createTeam(UserVO user, TeamVO teamvo);

	public List<TeamVO> findTeamByUser(int uid);
	
	public TeamVO findTeamByDomain(UserVO user, String domain);
}
