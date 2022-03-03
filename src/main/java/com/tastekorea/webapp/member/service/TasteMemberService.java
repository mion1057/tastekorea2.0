package com.tastekorea.webapp.member.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.auth.web.exception.LoginFailException;
import com.tastekorea.webapp.member.domain.TasteMember;

public interface TasteMemberService {

	/**
	 * Member정보 LanguageSkill 정보를 함께 저장
	 * 
	 * @param member
	 * @return
	 */
	TasteMember addMember(TasteMember member);

	/**
	 * 가이드 상세보기
	 * @param id
	 * @return
	 */
	TasteMember getMember(long id);

	/**
	 * 가이드 목록 조회
	 * 
	 * @param pageable
	 * @return
	 */
	Page<TasteMember> getMemberList(Pageable pageable);

	/**
	 * 가이드 목록 조회
	 * 
	 * @param pageable
	 * @return
	 */
	Page<TasteMember> getCompanionList(Pageable pageable);

	/**
	 * 여행자 목록 조회
	 * 
	 * @param pageable
	 * @return
	 */
	Page<TasteMember> getTravelerList(Pageable pageable);
	
	/**
	 * 회원 / 가이드 로그인 
	 * @throws LoginFailException 
	 */
	User loginMember(String email, String passwd) throws LoginFailException;

	/**
	 * 로그인 체크
	 * @param loginMap
	 * @return
	 */
	User loginCheck (Map<String, String> loginMap) throws LoginFailException;
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	User myPage(User user);

}