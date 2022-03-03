package com.tastekorea.webapp.pin.service;

import java.util.List;

import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinMapData;

/**
 * 
 * @author "rohyh"
 *
 */
public interface PinMapService {
	
	/**
	 * add
	 * @param pinMap
	 */
	void addPinMap(PinMapData pinMap);
	
	/**
	 * pinId로 등록된 좌표값 불러오기
	 * 
	 * @param pin
	 * @return
	 */
	PinMapData getMapDataByPinId(Pin pin);
	
	/**
	 * 등록된 모든 지도데이터 불러오기
	 * 
	 * @param pinMap
	 * @return
	 */
	List<PinMapData> getAllPinMapData(PinMapData pinMap);
}
