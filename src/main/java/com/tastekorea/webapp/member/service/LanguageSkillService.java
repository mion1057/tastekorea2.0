package com.tastekorea.webapp.member.service;

import java.util.List;

import com.tastekorea.webapp.member.domain.LanguageSkill;
import com.tastekorea.webapp.member.domain.TasteMember;


public interface LanguageSkillService {
	
	/**
	 * 
	 * @param ls
	 */
	void addLanguageSkill(LanguageSkill ls);

	
	/**
	 * 
	 * @param tasteMember
	 * @return
	 */
	List<LanguageSkill> getLanguageSkillListByMember(TasteMember tasteMember);

}