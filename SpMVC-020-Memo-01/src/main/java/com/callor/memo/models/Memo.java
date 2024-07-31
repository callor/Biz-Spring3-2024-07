package com.callor.memo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Memo {
	
	/*
	 * seq 일련번호라는 의미가 있지만
	 * DB 에서는 보통 PK 칼럼을 일컷는다
	 * 보통 seq 칼럼은 AUTO INCREMENT 로 정수값을 담도록 한다
	 * 하지만 최근 BigData 환경에서는
	 * 컴퓨터로 표현할수 있는 정수의 범위를 넘어서는 경우가 많다
	 * 최근 데이터 과학자 들은 정수형 보다는 UUID 문자열 형태의
	 * PK 를 사용할 것을 권장한다.
	 */
	private String m_seq;
	private String m_date;
	private String m_time;
	private String m_subject;
	private String m_content;


}
