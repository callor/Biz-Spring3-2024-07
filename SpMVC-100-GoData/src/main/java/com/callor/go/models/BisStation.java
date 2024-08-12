package com.callor.go.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BisStation {
	
	private String STATION_NUM;//		레코드 구분
	private String BUSSTOP_ID;//		정류소 ID
	private String BUSSTOP_NAME;//		정류소 명(국문)
	private String NAME_E;//			정류소 명(영문)
	private String LONGITUDE;//			위도
	private String LATITUDE; // 		경도
	private String NEXT_BUSSTOP; // 	다음정류장
	private String ARS_ID; // 			ARS 번호

	

}
