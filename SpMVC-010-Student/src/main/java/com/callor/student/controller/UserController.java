package com.callor.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return null;
	}
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String admin() {
		return null;
	}
}
