package com.tastekorea.webapp.pin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinMapData;

/**
 * 
 * @author "rohyh"
 *
 */
public class PinMapRowMapper implements RowMapper<PinMapData> {

	@Override
	public PinMapData mapRow(ResultSet rs, int rowNum) throws SQLException {
		PinMapData pinMap = new PinMapData();
		pinMap.setId(rs.getLong("id"));
		pinMap.setPin(new Pin(rs.getLong("pinId")));
		pinMap.setCoordinate(new Pin(rs.getString("coordinate")));
		pinMap.setRegDate(rs.getTimestamp("regDate"));
		pinMap.setUpdateDate(rs.getTimestamp("updateDate"));
		
		return pinMap;
	}
	
}
