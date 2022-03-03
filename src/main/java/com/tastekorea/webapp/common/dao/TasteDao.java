package com.tastekorea.webapp.common.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.slf4j.Slf4j;


/**
 * 
 * @author Sage R Lee
 *
 */
@Slf4j
public class TasteDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	/**
	 * MySQL에서 페이징 처리를 위한 쿼리를 구성한다.
	 * 예를 들어 다음과 같은 쿼리를 구성한다.
	 * 	SELECT * FROM Companion 
	 * 		ORDER BY 
	 * 		regDate				//order.getProperty()
	 * 		DESC 				//order.getDirection().name()
	 * 		LIMIT
	 * 		2					//pageable.getPageSize()
	 * 		OFFSET 
	 * 		0					//pageable.getOffset()
	 * 
	 * @param select
	 * @param pageable
	 * @return
	 */
	protected String pagingQuery(String select, Pageable pageable) {

		StringBuilder sql = new StringBuilder(select);
		log.debug("pre sql : " + sql.toString());

		Order order = !pageable.getSort().isEmpty() ? 
						pageable.getSort().toList().get(0) : Order.by("id");
		sql.append(" ORDER BY ");
		sql.append(order.getProperty());
		sql.append(" ");
		sql.append(order.getDirection().name());
		sql.append(" LIMIT ");
		sql.append(pageable.getPageSize());
		sql.append(" OFFSET ");
		sql.append(pageable.getOffset());

		log.debug("sql : " + sql.toString());
		
		return sql.toString();
	}
	
	
	/**
	 * 전달된 테이블의 총 행의 수를 리턴
	 * 
	 * @param tableName
	 * @return
	 */
	protected long count(String tableName) {
		return jdbcTemplate.queryForObject(
				"SELECT count(*) FROM " + tableName, Long.class);
	}

}