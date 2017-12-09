package com.yanalysis.oathink.entity.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.yanalysis.oathink.entity.OAThinkOrgn;

@Mapper
public interface OrginizationMapper {
	@Insert(value = "insert into orgn (name, email, phone, created_by) values "
			+ "(#{name,jdbcType=VARCHAR},"
			+ " #{email,jdbcType=VARCHAR},"
			+ " #{phone,jdbcType=VARCHAR},"
			+ " #{createBy,jdbcType=VARCHAR})")
	int insert(OAThinkOrgn record);
}
