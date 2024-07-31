package com.callor.memo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.models.Memo;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final MemoService memoService;
	public HomeController(MemoService memoService) {
		this.memoService = memoService;
	}

	// @Slf4j 를 선언하면 log 를 사용하는 아래 코드를 자동으로 생성한다
	// private final Logger log = LoggerFactory.getLogger(HomeController.class);
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
//		System.out.println("여기는 Home");
		log.debug("여기는 Home");
		
		List<Memo> memoList = memoService.selectAll();
		model.addAttribute("MEMOS",memoList);
		return "home";

	}
}
