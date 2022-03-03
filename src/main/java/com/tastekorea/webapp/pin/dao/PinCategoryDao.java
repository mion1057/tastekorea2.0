package com.tastekorea.webapp.pin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tastekorea.webapp.pin.domain.PinCategory;

/**
 * 
 * @author "rohyh"
 *
 */

@Repository
public class PinCategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * @return
	 */
	public List<PinCategory> findAll() {
		String sql ="SELECT * FROM PinCategory";
		return jdbcTemplate.query(sql, new PinCategoryRowMappper());
	}
}
