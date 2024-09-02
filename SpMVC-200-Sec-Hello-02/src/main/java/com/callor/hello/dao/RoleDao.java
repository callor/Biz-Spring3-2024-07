package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.model.RoleVO;

public interface RoleDao {

	public void create_role_table(String dumy);

	public int insert(List<RoleVO> roles);

	@Select("SELECT * FROM tbl_roles WHERE r_username = #{username}")
	public List<RoleVO> findByUsername(String username);

}
