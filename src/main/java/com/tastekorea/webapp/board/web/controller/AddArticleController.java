package com.tastekorea.webapp.board.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddArticleController {
	
	
	@GetMapping("/board/article/add")
	public String addArticleForm() {
		return "board/add_article";
	}
	
	@PostMapping(value={"/board/article/add"}, produces = "application/text; charset=UTF-8")
	public ResponseEntity<?> addArticle(String data){
		System.out.println("data : " + data);
		return ResponseEntity.ok(data);
		
	}
}