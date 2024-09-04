package com.callor.hello.user.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.model.UserVO;
import com.callor.hello.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private final UserService userService;
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping(value = "/login",method=RequestMethod.GET )
	public String login() {
		return null;
	}
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return null;
	}
	
	@RequestMapping(value= "/join",method=RequestMethod.POST)
	public String join(@ModelAttribute UserVO userVO,Model model) {
		
		try {
			userService.createUser(userVO);
		} catch (DataAccessException e) {
			model.addAttribute("ERROR","SQL");
			return null;
		}
		return "redirect:/";
	}
	
}
