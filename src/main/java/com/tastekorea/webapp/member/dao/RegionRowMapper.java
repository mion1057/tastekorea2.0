package com.tastekorea.webapp.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.member.domain.Region;

public class RegionRowMapper implements RowMapper<Region> {

	@Override
	public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
		Region region = new Region();
		region.setId(rs.getLong("id"));
		region.setKor(rs.getString("kor"));
		region.setEng(rs.getString("eng"));
		region.setGuide(rs.getBoolean("guide"));
		
		return region;
	}

}