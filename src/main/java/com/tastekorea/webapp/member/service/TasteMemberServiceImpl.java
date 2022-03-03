package com.tastekorea.webapp.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.auth.web.exception.LoginFailException;
import com.tastekorea.webapp.member.dao.TasteMemberDao;
import com.tastekorea.webapp.member.domain.LanguageSkill;
import com.tastekorea.webapp.member.domain.TasteMember;


/**
 * 
 * @author Sage R Lee
 *
 */
@Service
public class TasteMemberServiceImpl implements TasteMemberService {
	
	@Autowired
	private TasteMemberDao memberDao; 
	
	@Autowired
	private LanguageSkillService languageSkillService;
	
	/**
	 * Member���� LanguageSkill ������ �Բ� ����
	 * 
	 * @param member
	 * @return
	 */
	@Override
	public TasteMember addMember(TasteMember member) {
		//1.TasteMember ����
		long id = memberDao.save(member);
		member.setId(id);
		
		//2.LanguageSkill ��� ����
		List<LanguageSkill> skillList = member.getLanguageSkillList();
		for(LanguageSkill ls : skillList) {
			ls.setMember(member);
			languageSkillService.addLanguageSkill(ls);
		}
		return member;
	}
	
	
	/**
	 * ���̵� �󼼺���
	 * @param id
	 * @return
	 */
	@Override
	public TasteMember getMember(long id) {
		TasteMember member = memberDao.findById(id);
		List<LanguageSkill> skillList = languageSkillService.
				getLanguageSkillListByMember(member);
		member.setLanguageSkillList(skillList);
		
		return member;
	}
	
	
	/**
	 * ���̵� ��� ��ȸ
	 * 
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<TasteMember> getMemberList(Pageable pageable){
		return memberDao.findAll(pageable);
	}
	
	
	/**
	 * ���̵� ��� ��ȸ
	 * 
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<TasteMember> getCompanionList(Pageable pageable){
		return memberDao.findAllCompanions(pageable);
	}
	
	
	/**
	 * ������ ��� ��ȸ
	 * 
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<TasteMember> getTravelerList(Pageable pageable){
		return memberDao.findAllTravelers(pageable);
	}
	
	/**
	 * ������ / ���̵� �α��� 
	 * 
	 * @throws LoginFailException 
	 */
	@Override
	public User loginMember(String email, String passwd) throws LoginFailException {
		return memberDao.loginMember(email, passwd);
	}
	
	/**
	 * 
	 */
	@Override
	public User loginCheck(Map<String, String> loginMap) throws LoginFailException {
		
		return memberDao.loginCheck(loginMap);
	}

	/**
	 * 
	 */
	@Override
	public User myPage(User user) {
		return memberDao.myPage(user);
	}
}