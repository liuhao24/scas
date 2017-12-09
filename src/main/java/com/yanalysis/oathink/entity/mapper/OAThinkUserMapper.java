package com.yanalysis.oathink.entity.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.yanalysis.oathink.entity.OAThinkUser;

@Mapper
public interface OAThinkUserMapper {

	@Insert(value = "insert into roncoo_user (name, create_time) values (#{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})")
	int insert(OAThinkUser record);

	@Select(value = "select id, name, create_time from roncoo_user where id = #{id,jdbcType=INTEGER}")
	@Results(value = { @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	OAThinkUser selectByPrimaryKey(Integer id);
}
