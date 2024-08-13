package com.callor.go.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.go.models.BisStation;
import com.callor.go.service.BisService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	
	private final BisService bisService;
	public HomeController(BisService bisService) {
		super();
		this.bisService = bisService;
	}
	
	
	@RequestMapping(value="/")
	public String home(
			@RequestParam(
					name="station", 
					required = false, 
					defaultValue = "")  String station, Model model) {
		
		List<BisStation> bisList = bisService.getStations(station);
		model.addAttribute("BIS_LIST",bisList);
		return "station";
	}
	
	
//	@ResponseBody
//	@RequestMapping(value = "/", method = RequestMethod.GET,
//				produces = "application/json;charset=UTF-8")
//	
//	public List<BisStation> home(Locale locale, Model model) {
//		List<BisStation> bisList = bisService.getStations();
//		log.debug("HOME");
//		return bisList;
//	}
	
}
