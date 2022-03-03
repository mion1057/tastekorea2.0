package com.tastekorea.webapp.common.dao;

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

import com.tastekorea.webapp.common.domain.AppReply;


/**
 * 
 * @author Sage R Lee
 *
 */
@Repository
public class AppReplyDao extends TasteDao{
	
	private static final String SELECT = 
			"SELECT r.id, r.masterId, r.parentId, r.memberId, r.appCode, "
			+ " r.comment, r.recipient, r.priority, r.likeCount, r.dislikeCount, "
			+ " r.regDate, r.updateDate, m.id, m.alias, m.profileImage "
			+ " FROM AppReply r INNER JOIN TasteMember m ON r.memberId = m.id ";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 
	 * @param reply
	 * @return
	 */
	public long saveReply(AppReply reply) {
		String sql = "INSERT INTO AppReply(masterId, parentId, memberId, appCode,"
				+ " comment, recipient, priority, likeCount, dislikeCount) "
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator preparedStatementCreator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] { "id" });
			pstmt.setLong(1, reply.getMasterId());
			pstmt.setObject(2, reply.getParentId());
			pstmt.setLong(3, reply.getMember().getId());
			pstmt.setInt(4, reply.getAppCode());
			pstmt.setString(5, reply.getComment());
			pstmt.setString(6, reply.getRecipient());
			pstmt.setInt(7, reply.getPriority());
			pstmt.setInt(8, reply.getLikeCount());
			pstmt.setInt(9, reply.getDislikeCount());
			return pstmt;
		};
		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		return keyHolder.getKey().longValue();

	}
	
	
	/**
	 * 
	 * @param appCode
	 * @param pageable
	 * @return
	 */
	public Page<AppReply> findParentRepliesByAppCode(int appCode, Pageable pageable){
		String sql = pagingQuery(SELECT + " WHERE r.appCode=? AND r.parentId IS NULL", pageable);
		List<AppReply> list = jdbcTemplate.query(sql, new AppReplyRowMapper(), appCode);

		return new PageImpl<AppReply>(list, pageable, count("AppReply"));
	}
}