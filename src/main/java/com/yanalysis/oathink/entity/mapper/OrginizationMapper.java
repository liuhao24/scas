package com.yanalysis.oathink.entity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.yanalysis.oathink.entity.DepartmentEntity;
import com.yanalysis.oathink.entity.OAThinkOrgn;

@Mapper
public interface OrginizationMapper {
	@Insert(value = "insert into orgn (name, domain, email, phone, created_by) values " + "(#{name,jdbcType=VARCHAR},"
			+ " #{email,jdbcType=VARCHAR}," + " #{domain,jdbcType=VARCHAR}," + " #{phone,jdbcType=VARCHAR},"
			+ " #{createBy,jdbcType=VARCHAR})")
	int insert(OAThinkOrgn record);

	@Insert(value = "insert into department(name, domain, code, description, pgid, created_by) values "
			+ "(#{name, jdbcType=VARCHAR}, "
			+ " #{domain, jdbcType=VARCHAR},"
			+ " #{code, jdbcType=VARCHAR},"
			+ " #{description, jdbcType=VARCHAR},"
			+ " #{pgid, jdbcType=INTEGER},"
			+ " #{createdBy, jdbcType=VARCHAR})")
	int insertDepartment(DepartmentEntity dept);

	@Update(value = "update department set enable=false where gid = #{0}")
	void deleteDepartment(int id, int uid);

	@Update(value = "update department set name=#{1, jdbcType=VARCHAR}, "
			+ "description=#{2, jdbcType=VARCHAR},"
			+ "enable=#{3, jdbcType=BOOLEAN} where gid = #{0, jdbcType=INTEGER}")
	void updateDepartment(int id, String name, String desc, boolean enable);

	@Results(id = "deptResult", value = { @Result(property = "gid", column = "gid"),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "created_by", property = "createdBy", jdbcType = JdbcType.VARCHAR)})
	@Select("select * from department where gid = #{0, jdbcType=INTEGER}")
	DepartmentEntity findDepartment(int gid);

	@Results(id = "listDeptResult", value = { @Result(property = "gid", column = "gid"),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "created_by", property = "createdBy", jdbcType = JdbcType.VARCHAR)})
	@Select("select * from department where domain = #{0}")
	List<DepartmentEntity> listDepartment(String domain);
}
