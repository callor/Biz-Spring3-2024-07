package com.callor.student.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.student.models.StudentVO;
import com.callor.student.persistance.ScoreDao;
import com.callor.student.persistance.StudentDao;
import com.callor.student.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService{

	protected final StudentDao studentDao;
	protected final ScoreDao scoreDao;
	public StudentServiceImplV1(StudentDao studentDao, ScoreDao scoreDao) {
		super();
		this.studentDao = studentDao;
		this.scoreDao = scoreDao;
	}

	@Override
	public List<StudentVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentVO findById(String id) {

		StudentVO studentVO = studentDao.findById(id);
		studentVO.setSt_scores(scoreDao.findByStNum(id));
		return studentVO;

	}

}
