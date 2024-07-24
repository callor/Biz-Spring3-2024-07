package com.callor.student.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentVO {
	
	private String st_num;
	private String st_name;
	private String st_dept;
	private int st_grade;
	private String st_tel;
	private String st_addr;
	
	private List<ScoreVO> st_scores;

}
