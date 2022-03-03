package com.tastekorea.webapp.member.service;

import java.util.List;

import com.tastekorea.webapp.member.domain.Region;

public interface RegionService {

	/**
	 * 가이드 지역 목록
	 * @return
	 */
	List<Region> getLocalRegionList();

	/**
	 * 여행자 국가 목록
	 * @return
	 */
	List<Region> getCountryList();

}