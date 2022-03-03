package com.tastekorea.webapp.member.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tastekorea.webapp.common.Constants;
import com.tastekorea.webapp.common.vo.PageMaker;
import com.tastekorea.webapp.member.domain.TasteMember;
import com.tastekorea.webapp.member.service.TasteMemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GetMemberController {

	@Autowired
	private TasteMemberService memberService;
	
	
	/**
	 * 가이드 목록 조회
	 * /guide/companion/list
	 * /guide/companion/list?pageNum=1
	 * 
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@GetMapping("/member/{type}/list")
	public String listMembers(@PathVariable String type, 
			@RequestParam(defaultValue="1") int pageNum, Model model) {
		
		log.debug("pageNum : " + pageNum);
		pageNum = pageNum < 1 ? 0 : pageNum - 1;
		Pageable pageable = PageRequest.of(pageNum, Constants.FETCH_SIZE, 
											Sort.Direction.DESC, "regDate");
		
		Page<TasteMember> memberPage = null;
		String nextPage = null;
		if(type.equals("traveler")) {
			memberPage = memberService.getTravelerList(pageable);
			nextPage = "member/list_travelers";
		}else {
			memberPage = memberService.getCompanionList(pageable);
			nextPage = "member/list_companions";
		}
		model.addAttribute("memberPage", memberPage);
		model.addAttribute("pageMaker", new PageMaker<TasteMember>(memberPage));
		
		return nextPage;
	}
	
}