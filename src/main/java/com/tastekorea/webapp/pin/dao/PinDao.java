package com.tastekorea.webapp.pin.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tastekorea.webapp.common.dao.TasteDao;
import com.tastekorea.webapp.pin.domain.Pin;

@Repository
public class PinDao extends TasteDao{
	
	private static final String SELECT = 
			"SELECT p.*, c.eng AS cateEng, c.kor AS cateKor, r.eng As regionEng,"
			+ " r.kor AS regionKor, m.alias As memberAlias, m.profileImage As memberProfile"
			+ "	FROM Pin p INNER JOIN Region r ON p.regionId = r.id"
			+ "	INNER JOIN PinCategory c ON p.categoryId = c.id"
			+ "	INNER JOIN TasteMember m ON p.memberId = m.id";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 
	 * @param pin
	 * @return
	 */
	public long save(Pin pin) {
		String sql = "INSERT INTO Pin(memberId, regionId, categoryId, imagePath,"
		  		+ "title, description, mapData, likeCount, dislikeCount)"
		  		+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		  
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator preparedStatementCreator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] { "id" });
			pstmt.setLong(1, pin.getMember().getId());
			pstmt.setLong(2, pin.getRegion().getId());
			pstmt.setLong(3, pin.getCategory().getId());
			pstmt.setString(4, pin.getImagePath());
			pstmt.setString(5, pin.getTitle());
			pstmt.setString(6, pin.getDescription());
			pstmt.setString(7, pin.getMapData());
			pstmt.setInt(8, pin.getLike());
			pstmt.setInt(9, pin.getDislike());

			return pstmt;
		};
		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		return keyHolder.getKey().longValue();

	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Pin findById(long id) {
		String sql = SELECT + " WHERE p.id = ?";
		return jdbcTemplate.queryForObject(sql, new PinRowMapper(), id);
	}
	
	/**
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<Pin> findAllPin(Pageable pageable) {
		String sql = pagingQuery(SELECT, pageable);
		List<Pin> list = jdbcTemplate.query(sql, new PinRowMapper());
		
		return new PageImpl<Pin>(list, pageable, count("Pin"));
	}
	
	/**
	 * 
	 * @param categoryId
	 * @param pageable
	 * @return
	 */
	public Page<Pin> findByCategoryId(long categoryId, Pageable pageable){
		String sql = pagingQuery(SELECT + " WHERE p.categoryId = ?", pageable);
		List<Pin> list = jdbcTemplate.query(sql, new PinRowMapper(), categoryId);
		
		return new PageImpl<Pin>(list, pageable, count("Pin"));

	}
	
	
	/**
	 * 
	 * @param regionId
	 * @param pageable
	 * @return
	 */
	public Page<Pin> findByRegionId(long regionId, Pageable pageable){
		String sql = pagingQuery(SELECT + " WHERE p.regionId = ?", pageable);
		List<Pin> list = jdbcTemplate.query(sql, new PinRowMapper(), regionId);
		
		return new PageImpl<Pin>(list, pageable, count("Pin"));
	}
	
	
	/**
	 * 
	 * @param memberId
	 * @param pageable
	 * @return
	 */
	public Page<Pin> findByMemberId(long memberId, Pageable pageable){
		String sql = pagingQuery(SELECT + " WHERE p.memberId = ?", pageable);
		List<Pin> list = jdbcTemplate.query(sql, new PinRowMapper(), memberId);
		
		return new PageImpl<Pin>(list, pageable, count("Pin"));
	}
}