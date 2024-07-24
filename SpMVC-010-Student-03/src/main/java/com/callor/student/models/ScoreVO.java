package com.callor.student.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScoreVO {
	private String sc_stnum; //	varchar(5)
	private String sc_sbcode; //	varchar(5)
	
	private String sb_name; //	varchar(20)
	
	private int sc_score; //	int
}
