package com.callor.student.service;

import java.util.List;

import com.callor.student.models.StudentVO;

public interface StudentService {
	
	public List<StudentVO> selectAll();
	public StudentVO findById(String id);

}
