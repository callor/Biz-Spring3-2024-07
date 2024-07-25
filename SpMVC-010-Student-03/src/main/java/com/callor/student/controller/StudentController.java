package com.callor.student.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.student.models.StudentVO;
import com.callor.student.models.UserVO;
import com.callor.student.persistance.StudentDao;
import com.callor.student.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	private final StudentService studentService;
	private final StudentDao studentDao;
	public StudentController(StudentService studentService, StudentDao studentDao) {
		super();
		this.studentService = studentService;
		this.studentDao = studentDao;
	}

	// http://localhost:8080/student/student/ 로 request 가 오면
	// http://localhost:8080/student/student 로 request 가 오면
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(HttpSession httpSession, Model model) {
		
		UserVO userVO = (UserVO)httpSession.getAttribute("USER");
		if(userVO == null) {
			return "redirect:/user/login?error=need";
		}
		
		List<StudentVO> stList = studentDao.selectAll();
		model.addAttribute("ST_LIST", stList );
		return "student/list";

	}
}
