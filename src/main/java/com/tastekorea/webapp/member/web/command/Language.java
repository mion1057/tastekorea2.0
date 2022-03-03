package com.tastekorea.webapp.member.web.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Language {
	private long languageId;
	private String lang;
	
	public Language(long languageId, String lang) {
		super();
		this.languageId = languageId;
		this.lang = lang;
	}
	
	
}