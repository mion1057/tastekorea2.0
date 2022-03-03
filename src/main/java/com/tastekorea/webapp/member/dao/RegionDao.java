package com.tastekorea.webapp.member.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tastekorea.webapp.common.dao.TasteDao;
import com.tastekorea.webapp.member.domain.Region;


@Repository
public class RegionDao extends TasteDao{
	
	
	/**
	 * 가이드 지역 목록
	 * @return
	 */
	public List<Region> findLocalRegionList(){
		String sql = "SELECT * FROM Region WHERE guide = true";
		return jdbcTemplate.query(sql, new RegionRowMapper());
	}
	
	
	/**
	 * 여행자 국가 목록
	 * @return
	 */
	public List<Region> findCountryList(){
		String sql = "SELECT * FROM Region WHERE guide = false";
		return jdbcTemplate.query(sql, new RegionRowMapper());
	}
}