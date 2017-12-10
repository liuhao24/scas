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

	@Insert(value = "insert into oauser(name, pwd, salt, phone) values"
			+ " (#{name}, #{pwd}, #{salt}, #{phone})")
	int insert(OAThinkUser record);

	@Select(value = "select id, name, create_time from roncoo_user where id = #{id,jdbcType=INTEGER}")
	@Results(value = { @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	OAThinkUser selectByPrimaryKey(Integer id);

	@Select(value = "select id, name, phone, nick, pwd, salt, created_at from oauser where name = #{name,jdbcType=VARCHAR}")
	@Results(value = { @Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP) })
	OAThinkUser findByName(String name);
}
