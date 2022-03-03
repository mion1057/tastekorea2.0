package com.tastekorea.webapp.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.member.domain.ForeignLanguage;

/**
 * 
 * @author Sage R Lee
 *
 */
public class ForeignLanguageRowMapper implements RowMapper<ForeignLanguage> {
	
	/**
	 * 
	 */
	@Override
	public ForeignLanguage mapRow(ResultSet rs, int rowNum) throws SQLException {
		ForeignLanguage language = new ForeignLanguage();
		language.setId(rs.getLong("id"));
		language.setKor(rs.getString("kor"));
		language.setEng(rs.getString("eng"));
		language.setRegDate(rs.getTimestamp("regDate"));
		language.setUpdateDate(rs.getTimestamp("updateDate"));

		return language;
	}
}