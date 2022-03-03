package com.tastekorea.webapp.pin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinMapData;

/**
 * 
 * @author "rohyh"
 *
 */
public class PinMapDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 지도 좌표값 등록
	 * @param pinMap
	 */
	public void add(PinMapData pinMap) {
		String sql = "INSERT INTO PinMapData(pinId, coordinate) "
				+ "VALUES(?, ?)";
		
		jdbcTemplate.update(sql, pinMap.getPin().getId(), 
				pinMap.getPin().getMapData());
	}
	
	/**
	 * 단일 pin에 대한 좌표값 조회
	 * 
	 * @param pinMap
	 * @return
	 */
	public PinMapData findById(Pin pin) {
		String sql = "SELECT coordinate FROM PinMapData"
				+ "WHERE pinId = ?";
		return (PinMapData) jdbcTemplate.queryForObject(sql, new PinMapRowMapper(), pin.getId());
	}
	
	/**
	 * 전체 등록된 pin과
	 * 각각의 pin에 대응하는 좌표값 조회
	 * 
	 * @param pinMap
	 * @return
	 */
	public List<PinMapData> findAll(PinMapData pinMap) {
		String sql ="SELECT * FROM PinMapData";
		return jdbcTemplate.query(sql, new PinMapRowMapper());
	}

}
