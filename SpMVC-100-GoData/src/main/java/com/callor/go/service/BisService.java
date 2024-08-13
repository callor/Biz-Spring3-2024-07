package com.callor.go.service;

import java.util.List;

import com.callor.go.models.BisStation;
import com.callor.go.models.BusArrive;

public interface BisService {
	
	public List<BisStation> getStations(String station);
	public List<BusArrive> getBusArrive(String stopId);

}
