package com.tastekorea.webapp.member.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * [TasteMember]1 ------------ *[LanguageSkill]1 -----------> 1[ForeignLanguage]
 * 
 * @author Sage R Lee
 *
 */

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "language", callSuper = false)
public class LanguageSkill extends CommonEntity{
	
	@ManyToOne
	@JoinColumn(name="memberId")
	private TasteMember member;
	
	@OneToOne
	@JoinColumn(name="languageId")
	private ForeignLanguage language;
	private double skillLevel;		//언어수준	(0 ~ 5사이의 값으로 .5단위) 숫자를 별표로 표시
	
	public LanguageSkill() {
		super();
	}
	
	public LanguageSkill(ForeignLanguage language, double skillLevel) {
		super();
		this.language = language;
		this.skillLevel = skillLevel;
	}

	
	@Override
	public String toString() {
		return "LanguageSkill [member=" + member.getId() 
			+ ", language=" + language.getId() + ", skillLevel=" + skillLevel + "]";
	}
	
	
	
	
}