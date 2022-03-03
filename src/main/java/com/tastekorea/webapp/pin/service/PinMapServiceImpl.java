package com.tastekorea.webapp.pin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.pin.dao.PinMapDao;
import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinMapData;

/**
 * 
 * @author "rohyh"
 *
 */
@Service
public class PinMapServiceImpl implements PinMapService {
	
	@Autowired
	private PinMapDao pinMapDao;
	
	/**
	 * 
	 */
	@Override
	public void addPinMap(PinMapData pinMap) {
		pinMapDao.add(pinMap);
	}
	
	/**
	 * pinId로 등록된 좌표값 불러오기
	 */
	@Override
	public PinMapData getMapDataByPinId(Pin pin) {
		return pinMapDao.findById(pin);
	}
	
	/**
	 * 등록된 모든 지도데이터 불러오기
	 */
	@Override
	public List<PinMapData> getAllPinMapData(PinMapData pinMap) {
		return pinMapDao.findAll(pinMap);
	}
}
