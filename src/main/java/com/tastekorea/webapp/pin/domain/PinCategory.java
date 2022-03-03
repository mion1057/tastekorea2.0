package com.tastekorea.webapp.pin.domain;

import javax.persistence.Entity;

import com.tastekorea.webapp.common.domain.CommonEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * Pin에 관련된 속성, 특성들을 미리 나열하여
 * 정렬, 조회, 구분등을 용이하게 하려고 함 
 * 
 * 
 * [Pin]1 ------------ *[PinCategory]
 * 
 * 
 * ---------------
 * 카테고리 삽입 항목 *
 * ---------------
 * food & drink
 * sightseeing
 * arcade
 * beauty
 * sports & leisure
 * nature
 * shopping
 * translator
 * accomodation
 * transportation
 * etc..
 *  
 *  
 * @author holdv
 *
 */
@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
public class PinCategory extends CommonEntity {
	
	private String kor;
	private String eng;

	public PinCategory() {
		super();
	}
	
	public PinCategory(long id) {
		this.id = id;
	}
	
	public PinCategory(long id, String kor, String eng) {
		super();
		this.id = id;
		this.kor = kor;
		this.eng = eng;
	}

	public PinCategory(String kor, String eng) {
		super();
		this.kor = kor;
		this.eng = eng;
	}
}

