package com.tastekorea.webapp.member.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tastekorea.webapp.common.service.FileUploader;
import com.tastekorea.webapp.member.domain.ForeignLanguage;
import com.tastekorea.webapp.member.domain.Region;
import com.tastekorea.webapp.member.domain.TasteMember;
import com.tastekorea.webapp.member.service.ForeignLanguageService;
import com.tastekorea.webapp.member.service.RegionService;
import com.tastekorea.webapp.member.service.TasteMemberService;
import com.tastekorea.webapp.member.web.command.Language;
import com.tastekorea.webapp.member.web.command.LanguageSkillCommand;
import com.tastekorea.webapp.member.web.command.MemberCommand;
import com.tastekorea.webapp.member.web.command.RegionFormData;

import lombok.extern.slf4j.Slf4j;


/**
 * 
 * @author Sage R Lee
 *
 */
@Controller
@Slf4j
public class AddMemberController {
	
	@Autowired
	private TasteMemberService memberService;
	
	@Autowired
	private ForeignLanguageService languageService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private FileUploader fileUploader;
	
	
	/**
	 * 회원가입 폼
	 * 
	 * @param memberCommand
	 * @return
	 */
	@GetMapping("/member/{type}/add")
	public String addTasteMember(@PathVariable String type, MemberCommand mc) {
		log.debug("@GetMapping(/member/" + type + "/add)");
		
		String page = null;
		if(type.equals("traveler")) {
			page = "member/signup_traveler";
			
		}else {
			mc.setGuide(true);
			page = "member/signup_companion";
		}
		return page;
	}
	
	
	/**
	 * 회원가입
	 * 
	 * @param memberCommand
	 * @param model
	 * @return
	 */
	@PostMapping("/member/{type}/add")
	public String addTasteMember(MemberCommand memberCommand, Model model) {
		//1. TasteMember 기본값 등록
		TasteMember m = new TasteMember();
		m.setEmail(memberCommand.getEmail());
		m.setPasswd(memberCommand.getPasswd());
		m.setGuide(memberCommand.isGuide());
		m.setFirstName(memberCommand.getFirstName());
		m.setLastName(memberCommand.getLastName());
		m.setPhone(memberCommand.getPhone());
		m.setSsn(memberCommand.getSsn());
		m.setSex(memberCommand.getSex());
		m.setAlias(memberCommand.getAlias());
		m.setRegion(new Region(memberCommand.getRegion()));
		m.setIntroduction(memberCommand.getIntroduction());
		
		//2. TasteMember의 LangugeSkill 목록 등록
		List<LanguageSkillCommand> lsList = memberCommand.getLanguageSkillCommandList();
		for(LanguageSkillCommand ls : lsList) {
			if(ls.getLanguageId() != 0) {
				m.addLanguageSkill(ls.build());
			}
		}
		//3. TasteMember의 이미지 등록
		log.debug("memberCommand.getProfileImage(): " + memberCommand.getProfileImage());
		if(memberCommand.getProfileImage() != null) {
			m.setProfileImage(fileUploader.fileUpload(memberCommand.getProfileImage()));
		}
		
		m = memberService.addMember(m);
		model.addAttribute("member", m);
		
		return "member/welcome_member";
	}
	
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("foreignLanguageList")
	public List<Language> getAllLanguages(HttpServletRequest request){
		List<Language> list = new ArrayList<>();
		List<ForeignLanguage> langList = languageService.getAll();
		if(isGuideForm(request.getRequestURI())) {
			for(ForeignLanguage fl : langList) {
				list.add(new Language(fl.getId(), fl.getKor()));
			}
		}
		else {
			for(ForeignLanguage fl : langList) {
				list.add(new Language(fl.getId(), fl.getEng()));
			}
		}
		
		return list;
	}
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("regionList")
	public List<RegionFormData> getAllRegions(HttpServletRequest request){
		List<RegionFormData> list = new ArrayList<>();
		List<Region> regionList = null;
		if(isGuideForm(request.getRequestURI())) {
			regionList = regionService.getLocalRegionList();
			for(Region r : regionList) {
				list.add(new RegionFormData(r.getId(), r.getKor()));
			}
		}else {
			regionList = regionService.getCountryList();
			for(Region r : regionList) {
				list.add(new RegionFormData(r.getId(), r.getEng()));
			}
		}
		
		return list;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("languageLevelList")
	public List<String> getAllLevels(){
		List<String> list = new ArrayList<>();
		list.add("5");
		list.add("4.5");
		list.add("4");
		list.add("3.5");
		list.add("3");
		list.add("2.5");
		list.add("2");
		list.add("1.5");
		list.add("1");
		return list;
	}	
	
	
	
	private boolean isGuideForm(String requestUri) {
		if(requestUri.contains("companion")){
			return true;
		}
		return false;
	}
	
}