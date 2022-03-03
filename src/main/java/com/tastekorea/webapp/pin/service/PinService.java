package com.tastekorea.webapp.pin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tastekorea.webapp.pin.domain.Pin;

public interface PinService {

	/**
	 * 신규 Pin추가
	 * @param pin
	 * @return
	 */
	Pin addPin(Pin pin);

	/**
	 * id로 Pin 조회
	 * 
	 * @param id
	 * @return
	 */
	Pin getPin(long id);
	
	/**
	 * 등록된 모든 Pin 조회
	 * @param id
	 * @param pageable
	 * @return
	 */
	Page<Pin> getAllPinList(Pageable pageable);
	
	/**
	 * 특정 category의 Pin 목록 조회
	 * 
	 * @param categoryId
	 * @param pageable
	 * @return
	 */
	Page<Pin> getPinListByCategory(long categoryId, Pageable pageable);

	/**
	 * 특정 지역의 Pin 목록 조회
	 * 
	 * @param regionId
	 * @param pageable
	 * @return
	 */
	Page<Pin> getPinListByRegion(long regionId, Pageable pageable);

	/**
	 * 특정 가이드의 Pin 목록 조회
	 * 
	 * @param memberId
	 * @param pageable
	 * @return
	 */
	Page<Pin> getPinListByMember(long memberId, Pageable pageable);

}