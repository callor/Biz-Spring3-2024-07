package com.callor.hello.models;

public class HomeVO {
	
	private String c_name;
	private String c_tel;
	public HomeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HomeVO(String c_name, String c_tel) {
		super();
		this.c_name = c_name;
		this.c_tel = c_tel;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_tel() {
		return c_tel;
	}
	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}
	
	

}
