package com.callor.go.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BisStation {
	
//	@JsonProperty("STATION_NUM")
	public String STATION_NUM;//		레코드 구분
	public String BUSSTOP_ID;//		정류소 ID
	public String BUSSTOP_NAME;//		정류소 명(국문)
	public String NAME_E;//			정류소 명(영문)
	public String LONGITUDE;//			위도
	public String LATITUDE; // 		경도
	public String NEXT_BUSSTOP; // 	다음정류장
	public String ARS_ID; // 			ARS 번호

}
