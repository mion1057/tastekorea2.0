package com.tastekorea.webapp.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastekorea.webapp.member.domain.Region;
import com.tastekorea.webapp.member.domain.TasteMember;


/**
 * 
 * @author Sage R Lee
 *
 */
public class TasteMemberRowMapper implements RowMapper<TasteMember> {
	
	/**
	 * 
	 */
	@Override
	public TasteMember mapRow(ResultSet rs, int rowNum) throws SQLException {
		TasteMember tasteMember = new TasteMember();
		tasteMember.setId(rs.getLong("id"));
		tasteMember.setEmail(rs.getString("email"));
		tasteMember.setPasswd(rs.getString("passwd"));
		tasteMember.setGuide(rs.getBoolean("guide"));
		tasteMember.setFirstName(rs.getString("firstName"));
		tasteMember.setLastName(rs.getString("lastName"));
		tasteMember.setPhone(rs.getString("phone"));
		tasteMember.setSex(rs.getString("sex").charAt(0));
		tasteMember.setSsn(rs.getString("ssn"));
		tasteMember.setAlias(rs.getString("alias"));
		tasteMember.setProfileImage(rs.getString("profileImage"));
		tasteMember.setIntroduction(rs.getString("introduction"));
		tasteMember.setRegDate(rs.getTimestamp("regDate"));
		tasteMember.setUpdateDate(rs.getTimestamp("updateDate"));
		tasteMember.setRegion(new Region(rs.getString("kor"), 
							rs.getString("eng"), rs.getBoolean("r_guide")));
		return tasteMember;
	}
}