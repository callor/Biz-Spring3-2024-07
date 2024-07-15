package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.hello.service.HomeService;

@Service
public class HomeServiceImplV1 implements HomeService{

	@Override
	public List<String> getList() {
		List<String> list = new ArrayList<String>();
		list.add("Korea");
		list.add("대한민국");
		list.add("우리나라만세");
		return list;
	}

}
