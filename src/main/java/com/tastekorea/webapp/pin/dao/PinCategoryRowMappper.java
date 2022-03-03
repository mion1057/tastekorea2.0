package com.tastekorea.webapp.pin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.pin.domain.PinCategory;

/**
 * 
 * @author "rohyh"
 *
 */
public class PinCategoryRowMappper implements RowMapper<PinCategory> {

	@Override
	public PinCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		PinCategory category = new PinCategory();
		category.setId(rs.getLong("id"));
		category.setKor(rs.getString("kor"));
		category.setEng(rs.getString("eng"));
		category.setRegDate(rs.getTimestamp("regDate"));
		category.setUpdateDate(rs.getTimestamp("updateDate"));
		
		return category;
	}

}
