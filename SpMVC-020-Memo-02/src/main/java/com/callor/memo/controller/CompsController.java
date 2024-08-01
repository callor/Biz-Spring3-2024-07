package com.callor.memo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.models.Memo;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/comps")
public class CompsController {
	
	private final MemoService memoService;
	public CompsController(MemoService memoService) {
		super();
		this.memoService = memoService;
	}

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<Memo> memoList = memoService.selectAll();
		model.addAttribute("MEMOS",memoList);
		return null;
	}
	
	
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String input() {
		return null;
	}
	
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String input(@RequestBody Memo memo) {
		log.debug(memo.toString());
		String m_seq = memo.getM_seq();
		if(m_seq == null || m_seq.isBlank()) {
			memoService.insert(memo);
		} else {
			memoService.update(memo);
		}
		return "redirect:/comps/list";
	}

	
	// localhost:8080/memo/comps/update/333 과 같이 요청이 오면
	// {m_seq} path에 있는 문자열을 값으로 인식하고
	// m_seq 변수에 할당하라
	@RequestMapping(value="/update/{m_seq}",method=RequestMethod.GET)
	public String update(@PathVariable(name = "m_seq") String m_seq,Model model) {
		
		log.debug("PK: {}",m_seq);
		
		Memo memo = memoService.findById(m_seq);
		model.addAttribute("MEMO",memo);
		return "comps/input";

	}
	
	
	
}
