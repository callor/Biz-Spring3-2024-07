package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.StudentDao;
import com.callor.hello.models.StudentVO;

@Controller
public class StudentController {
	
	private final StudentDao studentDao;

	public StudentController(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	@RequestMapping(value="/student/list",method=RequestMethod.GET)
	public String getList(Model model) {
		
		List<StudentVO> stList = studentDao.selectAll();
		model.addAttribute("ST_LIST", stList);
		return null;
	}
	
}
