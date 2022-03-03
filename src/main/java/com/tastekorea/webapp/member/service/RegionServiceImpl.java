package com.tastekorea.webapp.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.member.dao.RegionDao;
import com.tastekorea.webapp.member.domain.Region;


/**
 * 
 * @author Sage R Lee
 *
 */
@Service
public class RegionServiceImpl implements RegionService {
	
	@Autowired
	private RegionDao regionDao;
	
	
	/**
	 * 가이드 지역 목록
	 * @return
	 */
	@Override
	public List<Region> getLocalRegionList() {
		return regionDao.findLocalRegionList();
	}
	
	
	/**
	 * 여행자 국가 목록
	 * @return
	 */
	@Override
	public List<Region> getCountryList(){
		return regionDao.findCountryList();
	}
}