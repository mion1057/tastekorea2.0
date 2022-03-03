package com.tastekorea.webapp.auth.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.auth.web.exception.LoginFailException;
import com.tastekorea.webapp.member.domain.LanguageSkill;
import com.tastekorea.webapp.member.service.TasteMemberService;

@Controller
public class MyPageController {
	
	@Autowired
	private TasteMemberService memberService;
	
	@GetMapping("/member/{type}/mypage")
	public String myPage(@PathVariable String type, HttpSession session, Model model) throws LoginFailException {
		
		User user = (User) session.getAttribute("user");
		
		List<LanguageSkill> userList =  (List<LanguageSkill>)session.getAttribute("list");		
		
		session.setAttribute("list", userList);
		
		model.addAttribute(user);
		
		String nextPage = null;
		if(type.equals("traveler")) {
			memberService.myPage(user);
			nextPage = "/member/information_traveler";
		}else {
			memberService.myPage(user);
			nextPage = "/member/information_companion";
		}
		
		return nextPage;
		
	}

	
	
	
}
