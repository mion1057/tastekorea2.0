package com.tastekorea.webapp.member.service;

import java.util.List;
import com.tastekorea.webapp.member.domain.ForeignLanguage;

public interface ForeignLanguageService {
	
	
	/**
	 * 등록된 외국어 목록 조회
	 * 
	 * @return
	 */
	public List<ForeignLanguage> getAll();
}