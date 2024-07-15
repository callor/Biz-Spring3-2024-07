package com.callor.hello.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.HomeVO;
import com.callor.hello.service.HomeService;

@Controller
public class HomeController {
	
	/*
	 * 의존성 주입
	 * 일반적인 Java 코드에서  다른 클래스에 선언된
	 * method, 변수 등을 사용하기 위해서
	 * 클래스의 생성자를 호출하여 객체를 생성한 후 사용해야 한다
	 * spring 에서는 클래스의 생성자를 호출하여 객체를 생성하는 
	 * 경우가 극히 드물다
	 * Service 클래스를 Controller 등에서 사용하기 위해서는
	 * 먼저 Service 클래스에 @Service Annotation 을 부착하여
	 * Spring Server 가 시작될때 Scan 하도록 하여두고
	 * 필요한 곳에서 생성자를 통하여 주입받아서 사용핟다
	 * 필요한 곳에서 필요하고 선언만 해두면, 생성된 객체를
	 * 자동으로 공급(주입)하여준다.
	 * 기존의 자바코드와 비교하면 객체를 생성하는 방향이 반대이다
	 * 이러한 것을 제어의 역전(Inverted of Control, IoC)
	 */
	private final HomeService homeService;
	public HomeController(HomeService homeService) {
		super();
		this.homeService = homeService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value="/next",method=RequestMethod.GET)
	public String next(Model model) {
		model.addAttribute("LIST",homeService.getList());
		return "next";
	}
	
	@RequestMapping(value="/next",method=RequestMethod.POST)
	public String next(String c_name, String c_tel, Model model) {
		List<String> list = homeService.getList();
		list.add(0, c_name);
		list.add(1,c_tel);
		model.addAttribute("LIST",list);
		return null;
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home() {
		return "next";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.POST)
	public String home(HomeVO homeVO, Model model) {
		List<String> list = new ArrayList<String>();
		list.add(homeVO.getC_name());
		list.add(homeVO.getC_tel());
		model.addAttribute("LIST",list);
		return "next";
	}
	
	
}
