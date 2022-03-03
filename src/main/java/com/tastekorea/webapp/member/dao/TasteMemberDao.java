package com.tastekorea.webapp.member.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.auth.web.exception.LoginFailException;
import com.tastekorea.webapp.common.dao.TasteDao;
import com.tastekorea.webapp.member.domain.TasteMember;


/**
 * 
 * @author Sage R Lee
 *
 */

@Repository
public class TasteMemberDao extends TasteDao {
	
	private static final String SELECT = 
			"SELECT m.id, m.email, m.passwd, m.guide, m.firstName, m.lastName, "
			+ " m.phone, m.sex, m.ssn, m.alias, m.profileImage, m.introduction, "
			+ " m.regDate, m.updateDate, r.kor, r.eng, r.guide AS r_guide "
			+ " FROM TasteMember m INNER JOIN Region r ON m.regionId = r.id ";
	
	/**
	 * 신규 회원 추가
	 * 
	 * @param member
	 * @return
	 */
	public long save(TasteMember member) {
		String sql = "INSERT INTO TasteMember("
				+ " email, passwd, guide, firstName, lastName, phone, ssn, sex, "
				+ " alias, profileImage, introduction, regionId)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator preparedStatementCreator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] { "id" });
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPasswd());
			pstmt.setBoolean(3, member.isGuide());
			pstmt.setString(4, member.getFirstName());
			pstmt.setString(5, member.getLastName());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getSsn());
			pstmt.setString(8, String.valueOf(member.getSex()));
			pstmt.setString(9, member.getAlias());
			pstmt.setString(10, member.getProfileImage());
			pstmt.setString(11, member.getIntroduction());
			pstmt.setLong(12, member.getRegion().getId());
			
			return pstmt;
		};
		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		
		return keyHolder.getKey().longValue();
	}
	
	
	/**
	 * id검색
	 * 
	 * @param id
	 * @return
	 */
	public TasteMember findById(long id) {
		String sql = SELECT + " WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new TasteMemberRowMapper(), id);
	}
	
	
	/**
	 * email검색
	 * 
	 * @param email
	 * @return
	 */
	public TasteMember findByEmail(String email) {
		String sql = SELECT + " WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new TasteMemberRowMapper(), email);
	}

	
	/**
	 * 회원 전체 목록 조회
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<TasteMember> findAll(Pageable pageable) {
		String sql = pagingQuery(SELECT, pageable);
		List<TasteMember> list = jdbcTemplate.query(sql, new TasteMemberRowMapper());
		 
		return new PageImpl<TasteMember>(list, pageable, count("TasteMember"));
	}
	
	
	/**
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<TasteMember> findAllCompanions(Pageable pageable) {
		String sql = pagingQuery(SELECT + " WHERE m.guide = true", pageable);
		List<TasteMember> list = jdbcTemplate.query(sql, new TasteMemberRowMapper());

		return new PageImpl<TasteMember>(list, pageable, count("TasteMember"));
	}
	
	
	/**
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<TasteMember> findAllTravelers(Pageable pageable) {
		String sql = pagingQuery(SELECT + " WHERE m.guide = false", pageable);
		List<TasteMember> list = jdbcTemplate.query(sql, new TasteMemberRowMapper());

		return new PageImpl<TasteMember>(list, pageable, count("TasteMember"));
	}
	
	
	/**
	 * 회원 로그인
	 * @param id
	 * @return
	 * @throws LoginFailException 
	 */
	public User loginMember(String email, String passwd) throws LoginFailException {
		String sql = SELECT + " WHERE email = ? AND passwd = ?";
		try {
		return jdbcTemplate.queryForObject(sql, new UserRowMapper() , email, passwd);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	/**
	 * 
	 * @param loginMap
	 * @return
	 * @throws LoginFailException
	 */
	public User loginCheck(Map<String, String> loginMap) throws LoginFailException {
		String email = loginMap.get("email");
		String passwd = loginMap.get("passwd");
		String sql = SELECT + " WHERE email = ? AND passwd = ?";
		try {
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(), email, passwd);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public User myPage(User user) {
		String sql = SELECT + "WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(), user.getEmail());
	}
	
	
}