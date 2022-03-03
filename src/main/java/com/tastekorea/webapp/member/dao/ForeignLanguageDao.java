package com.tastekorea.webapp.member.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tastekorea.webapp.member.domain.ForeignLanguage;


@Repository
public class ForeignLanguageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 
	 * @return
	 */
	public List<ForeignLanguage> findAll(){
		String sql = "SELECT * FROM ForeignLanguage";
		return jdbcTemplate.query(sql, new ForeignLanguageRowMapper());
	}
}