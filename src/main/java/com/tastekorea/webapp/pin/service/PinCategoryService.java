package com.tastekorea.webapp.pin.service;

import java.util.List;

import com.tastekorea.webapp.pin.domain.PinCategory;

/**
 * 
 * @author "rohyh"
 *
 */
public interface PinCategoryService {
	
	/**
	 * 모든 카테고리 조회
	 * @return
	 */
	List<PinCategory> getAll();
	
}
