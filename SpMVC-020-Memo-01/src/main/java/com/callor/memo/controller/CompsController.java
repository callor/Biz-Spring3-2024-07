package com.callor.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/comps")
public class CompsController {

	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String input() {
		return null;
	}
	
	
	
}
