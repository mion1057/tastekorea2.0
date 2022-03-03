package com.tastekorea.webapp.pin.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tastekorea.webapp.auth.web.command.User;
import com.tastekorea.webapp.common.Constants;
import com.tastekorea.webapp.common.service.FileUploader;
import com.tastekorea.webapp.member.domain.Region;
import com.tastekorea.webapp.member.domain.TasteMember;
import com.tastekorea.webapp.member.service.RegionService;
import com.tastekorea.webapp.member.web.command.RegionFormData;
import com.tastekorea.webapp.pin.domain.Pin;
import com.tastekorea.webapp.pin.domain.PinCategory;
////import com.tastekorea.webapp.pin.domain.PinMapData;
import com.tastekorea.webapp.pin.service.PinCategoryService;
import com.tastekorea.webapp.pin.service.PinService;
import com.tastekorea.webapp.pin.web.command.Category;
import com.tastekorea.webapp.pin.web.command.PinCommand;
//import com.tastekorea.webapp.pin.web.command.PinMapCommand;

import lombok.extern.slf4j.Slf4j;

/**
 * 작업중(미완성)
 * 
 * @author "rohyh"
 *
 */
@Controller
@Slf4j
public class AddPinController {

	@Autowired
	private PinService pinService;

	@Autowired
	private PinCategoryService pinCategoryService;

	@Autowired
	private RegionService regionService;

	@Autowired
	private FileUploader fileUploader;

	/**
	 * pin 등록 폼
	 * 
	 * @param pinCommand
	 * @return
	 */
	@GetMapping("/pin/add")
	public String addPin(PinCommand pinCommand, HttpSession session,
			Model model) {
		User user = (User) session.getAttribute("user");
		session.getAttribute("user");
		model.addAttribute("user", user);
		return "pin/add_pin";
	}

	/**
	 * pin 등록
	 * 
	 * @param pinCommand
	 * @param model
	 * @return
	 */
	@PostMapping("/pin/add")
	public String addPin(PinCommand pinCommand, Model model, HttpSession session) {
		// 1. Pin 기본값 등록
		Pin pin = new Pin();
		User user = (User) session.getAttribute("user");
		pinCommand.setMember(user.getId());
		pin.setMember(new TasteMember(pinCommand.getMember()));
		pin.setTitle(pinCommand.getTitle());
		pin.setMapData(pinCommand.getMapData());
		pin.setDescription(pinCommand.getDescription());
		pin.setMapData(pinCommand.getMapData());
		pin.setLike(pinCommand.getLike());
		pin.setDislike(pinCommand.getDislike());
		pin.setRegion(new Region(pinCommand.getRegion()));
		pin.setCategory(new PinCategory(pinCommand.getCategory()));

		// 2. Pin 이미지 등록
		log.debug("pinCommand.getImagePath(): " + pinCommand.getImagePath());
		if (pinCommand.getImagePath() != null) {
			pin.setImagePath(fileUploader.fileUpload(pinCommand.getImagePath()));
		}

		// 3. pin의 mapdata 등록
		// PinMapData map = new PinMapData();
		// PinMapCommand mapCommand = new PinMapCommand();
		// mapCommand.setCoordinate(pin.getMapData());

		// 최종 pin등록
		
		log.debug("memberId(): " + pinCommand.getMember());
		pin = pinService.addPin(pin);
		model.addAttribute("pin", pin);
		model.addAttribute("user", user);
		return "redirect:/";
	}

	/**
	 * 
	 * @return
	 */
	@ModelAttribute("regionList")
	public List<RegionFormData> getAllRegions(HttpServletRequest request) {
		List<RegionFormData> list = new ArrayList<>();
		List<Region> regionList = null;
		regionList = regionService.getLocalRegionList();
		for (Region r : regionList) {
			list.add(new RegionFormData(r.getId(), r.getKor()));
		}

		return list;
	}

	/**
	 * pin등록 폼에서 categoryList 출력
	 * 
	 * @param request
	 * @return
	 */
	@ModelAttribute("categoryList")
	public List<Category> getAllCategories(HttpServletRequest request) {
		List<Category> list = new ArrayList<>();
		List<PinCategory> categoryList = pinCategoryService.getAll();

		categoryList = pinCategoryService.getAll();
		for (PinCategory pinCat : categoryList) {
			list.add(new Category(pinCat.getId(), pinCat.getKor()));
		}

		return list;
	}

}