package com.yanalysis.oathink.orgnization.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yanalysis.oathink.entity.DepartmentEntity;
import com.yanalysis.oathink.entity.TeamEntity;
import com.yanalysis.oathink.entity.mapper.TeamMapper;
import com.yanalysis.oathink.orgnization.model.DepartmentVO;
import com.yanalysis.oathink.orgnization.model.TeamVO;
import com.yanalysis.oathink.orgnization.service.TeamService;
import com.yanalysis.oathink.user.model.UserVO;
@Component
public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamMapper teamMapper = null;
	
	@Override
	public TeamVO createTeam(UserVO user, TeamVO teamvo) {
		TeamEntity team = new TeamEntity();
		team.setName(teamvo.getOrgName());
		team.setDomain(teamvo.getOrgDomain());
		team.setDescription(teamvo.getDesc());
		team.setOwner(user.getUid());
		team.setDescription(teamvo.getDesc());
		int id = teamMapper.insert(team);
		teamvo.setId(id);
		return teamvo;
	}

	@Override
	public List<TeamVO> findTeamByUser(int uid) {
		List<TeamEntity> list = teamMapper.listTeam(uid);
		if (list != null) {
			List<TeamVO> result = new ArrayList<>(list.size());
			Iterator<TeamEntity> iter = list.iterator();
			while (iter.hasNext()) {
				result.add(entityToVO(iter.next()));
			}
			return result;
		}
		return null;
	}

	private TeamVO entityToVO(TeamEntity team) {
		TeamVO vo = new TeamVO();
		vo.setId(team.getId());
		vo.setOrgDomain(team.getDomain());
		vo.setDesc(team.getDescription());
		return vo;
	}
	@Override
	public TeamVO findTeamByDomain(UserVO user, String domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
