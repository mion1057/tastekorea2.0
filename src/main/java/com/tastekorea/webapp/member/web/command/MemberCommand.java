package com.tastekorea.webapp.member.web.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCommand {
	//------------------------
	//		로그인 정보
	//------------------------
	private String email;
	private String passwd;
	private boolean guide;			//가이드 여부
	
	//------------------------
	//		기본 신상 정보
	//------------------------	
	private String firstName;
	private String lastName;
	private long region;			//지역(가이드), 국적(여행자)
	private char sex;				//필수정보(안전성)
	
	private String phone;
	private String ssn;
	private String alias;
	private MultipartFile profileImage;
	private String introduction;
	
	//------------------------
	//		가능한 언어 정보
	//------------------------	
	private List<LanguageSkillCommand> languageSkillCommandList; 
	
	
	public MemberCommand() {
		if(languageSkillCommandList == null) {
			languageSkillCommandList = new ArrayList<>(); 
		}
	}
	
}