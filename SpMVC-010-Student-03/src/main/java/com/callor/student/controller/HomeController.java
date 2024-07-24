package com.callor.student.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.student.models.StudentVO;
import com.callor.student.persistance.StudentDao;
import com.callor.student.service.StudentService;

@Controller
public class HomeController {
	
	private final StudentService studentService;
	private final StudentDao studentDao;
	public HomeController(StudentService studentService, StudentDao studentDao) {
		super();
		this.studentService = studentService;
		this.studentDao = studentDao;
	}

	// http://localhost:8080/student/ 로 request 가 오면
	// http://localhost:8080/student 로 request 가 오면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<StudentVO> stList = studentDao.selectAll();
		model.addAttribute("ST_LIST", stList );
		return "home";

	}
	
	@ResponseBody
	@RequestMapping(value="/num_check",method=RequestMethod.GET)
	public String stNumCheck(String st_num) {
		/*
		 * findById(id) method 는 PK를 기준으로 SELECT 하여 그 결과를
		 * return  한다
		 * 만약 id 에 해당하는 데이터가 있으면 그 데이터를 return 하고
		 * 없으면 null 값을 return 한다
		 */
		StudentVO studentVO = studentDao.findById(st_num);
		if(studentVO == null) {
			return "NOT FOUND";
		}
		return "FOUND";
	}
	
	
	// 학생정보를 입력받기 위한 화면을 보여주는 method
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "student/input";
	}
	
	// 학생정보 입력화면에서 데이터를 입력한 후 전송(저장)을 클릭했을때
	// 데이터를 전달받은 method
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(StudentVO studentVO,Model model) {
		model.addAttribute("STD",studentVO);
		
		int result = studentDao.insert(studentVO);
		
//		List<StudentVO> stList = studentDao.selectAll();
//		model.addAttribute("ST_LIST",stList);
//		return "home";
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(String st_num,Model model) {
		/*
		 * studentDao.findById() 를
		 * studentService.findById() 로 변경
		 */
		StudentVO studentVO = studentService.findById(st_num);
		model.addAttribute("ST",studentVO);
		return "student/detail";
	}

	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String num,Model model) {
		
		StudentVO studentVO = studentDao.findById(num);
		model.addAttribute("ST",studentVO);
		
		// update 를 실행할때 새로은 update.jsp 를 만들지 않고
		// input.jsp 를 재활용 하겠다 
		return "student/input";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(String num, StudentVO studentVO) {
		studentVO.setSt_num(num);
		int result = studentDao.update(studentVO);
		return "redirect:/detail?st_num=" + num;
	}
	
	
	
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String st_num) {
		int result = studentDao.delete(st_num);
		return "redirect:/";
	}

	
	
	
}
