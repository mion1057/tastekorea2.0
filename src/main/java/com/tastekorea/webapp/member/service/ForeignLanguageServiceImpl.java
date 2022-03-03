package com.tastekorea.webapp.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.member.dao.ForeignLanguageDao;
import com.tastekorea.webapp.member.domain.ForeignLanguage;



/**
 * 
 * @author Sage R Lee
 *
 */
@Service
public class ForeignLanguageServiceImpl implements ForeignLanguageService{
	
	@Autowired
	private ForeignLanguageDao languageDao;
	
	
	
	/**
	 * 
	 */
	@Override
	public List<ForeignLanguage> getAll() {
		return languageDao.findAll();
	}

}