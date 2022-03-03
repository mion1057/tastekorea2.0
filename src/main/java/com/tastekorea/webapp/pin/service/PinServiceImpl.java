package com.tastekorea.webapp.pin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.pin.dao.PinDao;
import com.tastekorea.webapp.pin.domain.Pin;


/**
 * 
 * @author Sage R Lee
 *
 */
@Service
public class PinServiceImpl implements PinService{
	
	@Autowired
	private PinDao pinDao;
	
	/**
	 * 신규 Pin추가
	 * @param pin
	 * @return
	 */
	@Override
	public Pin addPin(Pin pin) {
		long id = pinDao.save(pin);
		pin.setId(id);
		return pin;
	}
	
	
	/**
	 * id로 Pin 조회
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Pin getPin(long id) {
		return pinDao.findById(id);
	}
	
	/**
	 * 등록된 모든 핀 조회
	 * 
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Pin> getAllPinList(Pageable pageable) {
		return pinDao.findAllPin(pageable);
	}
	
	/**
	 * 특정 category의 Pin 목록 조회
	 * 
	 * @param categoryId
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Pin> getPinListByCategory(long categoryId, Pageable pageable){
		return pinDao.findByCategoryId(categoryId, pageable);
	}
	
	
	/**
	 * 특정 지역의 Pin 목록 조회
	 * 
	 * @param regionId
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Pin> getPinListByRegion(long regionId, Pageable pageable){
		return pinDao.findByRegionId(regionId, pageable);
	}
	
	
	/**
	 * 특정 가이드의 Pin 목록 조회
	 * 
	 * @param memberId
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Pin> getPinListByMember(long memberId, Pageable pageable){
		return pinDao.findByMemberId(memberId, pageable);
	}	
}