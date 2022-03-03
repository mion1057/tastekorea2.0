package com.tastekorea.webapp.pin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.pin.dao.PinCategoryDao;
import com.tastekorea.webapp.pin.domain.PinCategory;

@Service
public class PinCategoryServiceImpl implements PinCategoryService{
	
	@Autowired
	private PinCategoryDao pinCategoryDao;
	
	/**
	 * 모든 카테고리 조회
	 * @return
	 */
	@Override
	public List<PinCategory> getAll() {
		return pinCategoryDao.findAll();
	}
}
