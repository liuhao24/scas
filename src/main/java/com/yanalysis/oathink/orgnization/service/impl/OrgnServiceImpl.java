package com.yanalysis.oathink.orgnization.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanalysis.oathink.entity.DepartmentEntity;
import com.yanalysis.oathink.entity.mapper.OrginizationMapper;
import com.yanalysis.oathink.orgnization.model.DepartmentVO;
import com.yanalysis.oathink.orgnization.service.OrgnService;
import com.yanalysis.oathink.user.model.UserVO;

@Service
public class OrgnServiceImpl implements OrgnService {

	@Autowired
	OrginizationMapper orgnMapper = null;

	@Override
	public void createDepartment(UserVO user, DepartmentVO vo) {
		DepartmentEntity dept = new DepartmentEntity();
		dept.setName(vo.getDeptName());
		dept.setCode(vo.getCode());
		dept.setPgid(vo.getPgid());
		dept.setDomain(vo.getOrgDomain());
		dept.setCreatedBy(Integer.parseInt(user.getUid()));
		dept.setDescription(vo.getDeptDesc());
		dept.setEnable(vo.isEnable());
		int gid = orgnMapper.insertDepartment(dept);
		vo.setId(gid);
	}

	@Override
	public void disableDepartment(UserVO user, int id) {
		orgnMapper.deleteDepartment(id, Integer.parseInt(user.getUid()));
	}

	@Override
	public void updateDepartment(UserVO user, DepartmentVO vo) {
		orgnMapper.updateDepartment(vo.getId(), vo.getDeptName(), vo.getDeptDesc(), vo.isEnable());
	}

	@Override
	public DepartmentVO findDepartment(UserVO user, String gid) {
		DepartmentEntity dept = orgnMapper.findDepartment(Integer.parseInt(gid));
		return entityToVO(dept);
	}

	@Override
	public List<DepartmentVO> listDepartment(UserVO user, String domain) {
		List<DepartmentEntity> dept = orgnMapper.listDepartment(domain);

		if (dept != null) {
			List<DepartmentVO> result = new ArrayList<>(dept.size());
			Iterator<DepartmentEntity> iter = dept.iterator();
			while (iter.hasNext()) {
				result.add(entityToVO(iter.next()));
			}
			return result;
		}
		return null;
	}

	private DepartmentVO entityToVO(DepartmentEntity dept) {
		DepartmentVO vo = new DepartmentVO();
		vo.setCode(dept.getCode());
		vo.setDeptName(dept.getName());
		vo.setDeptDesc(dept.getDescription());
		vo.setOrgDomain(dept.getDomain());
		vo.setId(dept.getGid());
		vo.setPgid(dept.getPgid());
		return vo;
	}

}
