package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.StudentVO;

public interface StudentDao {
	
	@Select("SELECT * FROM tbl_student")
	public List<StudentVO> selectAll();

}
