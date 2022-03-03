package com.tastekorea.webapp.common.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AppHitDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * @Modifying
	 * @Query("UPDATE AppHit a SET a.hit = a.hits + 1 WHERE a.resourceId = ?1 AND a.appCode = ?2")
	 * @param appContentId
	 */
	public void updateHitCount(long resourceId, int appCode) {
		String sql = "UPDATE AppHit a SET a.hit = (a.hits + 1)"
				+ " WHERE a.resourceId = ? AND a.appCode = ?";
		   
		jdbcTemplate.update(sql, resourceId, appCode);
	}
}