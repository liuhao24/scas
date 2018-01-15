package com.yanalysis.oathink.orgnization.service;

import java.util.List;

import com.yanalysis.oathink.orgnization.model.DepartmentVO;
import com.yanalysis.oathink.user.model.UserVO;

public interface OrgnService {

	void createDepartment(UserVO user, DepartmentVO department);

	void disableDepartment(UserVO user, int id);

	void updateDepartment(UserVO user, DepartmentVO department);

	DepartmentVO findDepartment(UserVO user, String gid);

	List<DepartmentVO> listDepartment(UserVO user, String domain);

}
