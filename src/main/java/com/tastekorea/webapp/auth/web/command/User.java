package com.tastekorea.webapp.auth.web.command;

import com.tastekorea.webapp.common.domain.CommonEntity;
import com.tastekorea.webapp.member.domain.ForeignLanguage;
import com.tastekorea.webapp.member.domain.LanguageSkill;
import com.tastekorea.webapp.member.domain.Region;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends CommonEntity {
	
	//------------------------
	//		기본 신상 공통 정보
	//------------------------
	private String email;
	private String firstName;
	private String lastName;
	private char sex;
	private Region region;
	private boolean guide;
	private String alias;
	
	//------------------------
	//		가이드 필수 정보
	//------------------------
	private String phone;
	private String ssn;
	private LanguageSkill skill;
	private String profileImage;
	private String introduction;
	
	public User(long id) {
		super();
		this.id = id;
	}

	public User() {
		super();
	}

	public String getDetail() {
		return "TasteMember [email=" + email + ", name=" + firstName + 
				lastName + ", region=" + region.getEng() +", phone=" + phone + 
				", ssn=" + ssn + ", sex=" + sex + 
				", profileImage=" + profileImage //+ ", provision=" + provision 
				+ ", introduction=" + introduction + "]";
	}
	
}
