package com.callor.go.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.go.config.DataGoConfig;
import com.callor.go.models.BisStation;
import com.callor.go.models.BisStationList;
import com.callor.go.models.BusArrive;
import com.callor.go.models.BusArriveList;
import com.callor.go.service.BisService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BisServiceImpl implements BisService {

	@Override
	public List<BisStation> getStations(String station) {

		String apiURI = DataGoConfig.BIS_URL;
		apiURI += "?serviceKey=" + DataGoConfig.GO_API_KEY;
		
		URI bisURI = null;
		try {
			bisURI = new URI(apiURI);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestTemplate restTemplate = new RestTemplate();
		
		/*
		 * 공공DB(data.go.kr)에서 Rest 방식으로 받은 데이터는
		 * 원칙적으로 application/json type 으로 전달된다
		 * 일부 공공DB 서비스중에 text/json type 으로 전달되는
		 * 데이터가 있다
		 * 이러한 데이터를(text/json) 을 객체타입(application/json)으로
		 * 변환 하기 위하여 중간에 데이터를 가로채서 처리하는 과정
		 */
		restTemplate.getInterceptors().add((request,body,execution)->{
			ClientHttpResponse response = execution.execute(request, body);
			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
			return response;
		});
		
		ResponseEntity<BisStationList> bisListEntity = null;
        
		bisListEntity = restTemplate.exchange(
				bisURI,
				HttpMethod.GET,
				null,
				BisStationList.class);

		// 수신한 데이터중에서 정류장정보만 추출하기
		List<BisStation> bisList = bisListEntity.getBody().STATION_LIST;
		
		/*
		 * Java 1.8 이상에서 사용하는 stream을 이용하여
		 * List 를 filtering 하기
		 */
		if(!station.isEmpty()) {
			bisList = bisList.stream()
			.filter(bis->bis.BUSSTOP_NAME.contains(station))
			.collect(Collectors.toList());
		}

		/*
		 * 전통적인 forEach를 사용하여 List를 filtering 하기
		 */
//		List<BisStation> result = new ArrayList<>();
//		for(BisStation bis : bisList) {
//			if(bis.BUSSTOP_NAME.contains(station)) {
//				result.add(bis);
//			}
//		}

		log.debug("받은데이터 {}",bisList.toString());
		return bisList;
	}

	@Override
	public List<BusArrive> getBusArrive(String busId) {

		String apiURL = DataGoConfig.ARRIVE_URL;
		apiURL += "?serviceKey=" + DataGoConfig.GO_API_KEY;
		apiURL += "&BUSSTOP_ID=" + busId;

		log.debug("API URL {}",apiURL);
		URI arriveURI = null;
		try {
			arriveURI = new URI(apiURL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request,body,execution)->{
			ClientHttpResponse response = execution.execute(request, body);
			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
			return response;
		});
		
		ResponseEntity<BusArriveList> busArriveEntity 
		= restTemplate.exchange(
				arriveURI,
				HttpMethod.GET, 
				null,
				BusArriveList.class);
		
		log.debug("도착정보 {}",busArriveEntity);
		
		return busArriveEntity.getBody().BUSSTOP_LIST;

	}

}
