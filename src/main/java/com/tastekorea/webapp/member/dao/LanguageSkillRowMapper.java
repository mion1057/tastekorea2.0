package com.tastekorea.webapp.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.member.domain.ForeignLanguage;
import com.tastekorea.webapp.member.domain.LanguageSkill;
import com.tastekorea.webapp.member.domain.TasteMember;

/**
 * 
 * @author Sage R Lee
 *
 */
public class LanguageSkillRowMapper implements RowMapper<LanguageSkill> {
	
	/**
	 * 
	 */
	@Override
	public LanguageSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
		LanguageSkill languageSkill = new LanguageSkill();
		languageSkill.setId(rs.getLong("id"));
		languageSkill.setMember(new TasteMember(rs.getLong("memberId")));
		languageSkill.setLanguage(new ForeignLanguage(rs.getLong("languageId")));
		languageSkill.setSkillLevel(rs.getDouble("skillLevel"));
		languageSkill.setRegDate(rs.getTimestamp("regDate"));
		languageSkill.setUpdateDate(rs.getTimestamp("updateDate"));

		return languageSkill;
	}

}