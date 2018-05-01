package com.yanalysis.oathink.entity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.yanalysis.oathink.entity.TeamEntity;

@Mapper
public interface TeamMapper {
	@Insert(value = "insert into team (name, domain, description, owner, created_by) values "
			+ "(#{name,jdbcType=VARCHAR}," + " #{domain,jdbcType=VARCHAR}," + " #{description,jdbcType=VARCHAR},"
			+ " #{owner,jdbcType=INTEGER}," + " #{createBy,jdbcType=INTEGER})")
	int insert(TeamEntity record);

	@Results(id = "listTeamResult", value = { @Result(property = "id", column = "id"),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "created_by", property = "createdBy", jdbcType = JdbcType.INTEGER),
			@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_by", property = "updatedAt", jdbcType = JdbcType.INTEGER),})
	@Select("select * from team where uid = #{0}")
	List<TeamEntity> listTeam(int uid);
}
