package com.callor.go.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.go.config.DataGoConfig;
import com.callor.go.models.BisStation;
import com.callor.go.models.BisStationList;
import com.callor.go.service.BisService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BisServiceImpl implements BisService {

	@Override
	public List<BisStation> getStations() {

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
		
		restTemplate.getInterceptors().add((request,body,execution)->{
			ClientHttpResponse response = execution.execute(request, body);
			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
			return response;
		});
		
		ResponseEntity<BisStationList> bisList = null;
        
		bisList = restTemplate.exchange(
				bisURI,
				HttpMethod.GET,
				null,
				BisStationList.class);
		
		log.debug(bisList.getBody().STATION_LIST.toString());
//		log.debug(temp.toString());
		
		return bisList.getBody().STATION_LIST;
//		return null;
	}

}
