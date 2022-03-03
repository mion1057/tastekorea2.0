package com.tastekorea.webapp.main.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.common.Constants;
import com.tastekorea.webapp.common.vo.PageMaker;
import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.service.PinService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainIndexController {
	
	@Autowired
	private PinService pinService;
	@GetMapping("/")
	public String index(@RequestParam(defaultValue="1") int pageNum, Model model,
			HttpSession session) {
		User user = (User) session.getAttribute("user");		
		log.debug("pageNum : " + pageNum);
		pageNum = pageNum < 1 ? 0 : pageNum - 1;
		Pageable pageable = PageRequest.of(pageNum, Constants.FETCH_SIZE, 
											Sort.Direction.DESC, "regDate");
		
		Page<Pin> pinPage = null;
		String nextPage = null;
		pinPage = pinService.getAllPinList(pageable);
		nextPage = "pin/list_pins";
		model.addAttribute("pinPage", pinPage);
		model.addAttribute("user", user);
		model.addAttribute("pageMaker", new PageMaker<Pin>(pinPage));
		return "index";
	}

}