package com.callor.hello.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StudentVO {
	private String st_num;//	varchar2(5 byte)
	private String st_name;//	nvarchar2(20 char)
	private String st_dept;//	nvarchar2(20 char)
	private int st_grade;//	number
	private String st_tel;//	varchar2(20 byte)
	private String st_addr;//	nvarchar2(125 char)
}
