package com.tastekorea.webapp.member.domain;

import javax.persistence.Entity;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * 언어정보
 * 
 * @author Sage R Lee
 *
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ForeignLanguage extends CommonEntity{
	
	private String kor;		//한국어
	private String eng;		//언어
	
	public ForeignLanguage() {
		super();
	}
	
	public ForeignLanguage(long id) {
		super.id = id;
	}
}