package com.tastekorea.webapp.member.web.command;


import com.tastekorea.webapp.member.domain.ForeignLanguage;
import com.tastekorea.webapp.member.domain.LanguageSkill;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LanguageSkillCommand {
	private long languageId;
	private String lang;
	private double skillLevel;
	
	public LanguageSkill build() {
		return new LanguageSkill(new ForeignLanguage(languageId), skillLevel);
	}
}